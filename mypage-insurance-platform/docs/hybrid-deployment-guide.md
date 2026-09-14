# Hybrid Architecture Deployment Guide

This document outlines the end-to-end build, deployment, and configuration process for the MyPage Insurance Platform. The architecture is a **Hybrid Model**, consisting of the legacy Liferay Portal hosted on a Linux VM and the modern Node.js/React platform hosted on Red Hat OpenShift.

---

## 1. Architecture & Networking Prerequisites

Because the solution spans two distinct infrastructure environments, specific network routes must be whitelisted by the network/firewall team prior to deployment.

### Required Network Paths
1. **Liferay VM ➔ OpenShift API (Port 443):** 
   - **Why:** The Liferay OSGi component (`DynamicProductPanelAppRegistrar`) makes a backend HTTP request to the Node.js API to fetch the active products and render the Liferay Sidebar.
2. **OpenShift API ➔ Liferay VM (Port 443):** 
   - **Why:** The Node.js API (`liferay-sync.service.ts`) calls Liferay's `/api/jsonws` endpoints to synchronize and write back configurations for legacy products.
3. **End-User Browser ➔ OpenShift Admin (Port 443):** 
   - **Why:** The Liferay portal embeds the OpenShift React App via an IFrame. The administrator's browser must be able to resolve and load the OpenShift route.

---

## 2. Modern Platform Deployment (OpenShift)

**Repository:** `mypage-insurance-platform`
**Tech Stack:** Node.js, Fastify, React, PostgreSQL

The modern platform must be deployed **first** so that its API is available when Liferay boots up.

### Step 2.1: Environment & Secrets Configuration
Before deploying, ensure the OpenShift Secrets and ConfigMaps are populated.
1. Navigate to the `openshift/` directory.
2. Edit or inject the following values into your CI/CD pipeline for `secret.yaml`:
   - `DATABASE_URL`: Connection string for PostgreSQL.
   - `JWT_SECRET`: A strong 256-bit secure key.
   - `OIDC_CLIENT_SECRET`: From OneAccount AXA SSO.
   - `LIFERAY_API_PASSWORD`: Liferay service account password.

### Step 2.2: Docker Build & Publish
Your CI/CD pipeline (Jenkins/GitLab) should build the multi-stage Dockerfiles.
```bash
# 1. Build and tag the API
docker build -t artifactory.europe.axa-cloud.com/insurance-api:latest -f packages/api/Dockerfile .

# 2. Build and tag the React Admin UI
docker build -t artifactory.europe.axa-cloud.com/insurance-admin:latest -f packages/admin/Dockerfile .

# 3. Push to AXA Artifactory Registry
docker push artifactory.europe.axa-cloud.com/insurance-api:latest
docker push artifactory.europe.axa-cloud.com/insurance-admin:latest
```

### Step 2.3: Database Migration
Before spinning up the new API pods, the database schema must be applied. This is typically done via an OpenShift Job or an InitContainer.
```bash
# Command executed inside the API container before startup:
npx prisma migrate deploy
```

### Step 2.4: OpenShift Application Apply
Apply the Kubernetes/OpenShift manifests to the cluster:
```bash
oc project mypage-insurance-prod
oc apply -f openshift/configmap.yaml
oc apply -f openshift/secret.yaml
oc apply -f openshift/deployment-api.yaml
oc apply -f openshift/deployment-admin.yaml
oc apply -f openshift/service.yaml
oc apply -f openshift/route.yaml
```

**Verification:**
- Run `oc get pods` to ensure `api` and `admin` pods are `Running`.
- Visit `https://api.modern-platform.axa.co.id/health` to verify the API returns HTTP 200.

---

## 3. Liferay Deployment (Linux VM)

**Repository:** `my-page-liferay`
**Tech Stack:** Java 8/11, Liferay 7.x, OSGi, Gradle

### Step 3.1: Liferay Properties Configuration
Ensure the Liferay environment is configured to point to the new OpenShift API. Add the following to `portal-ext.properties` on the Linux VM:
```properties
# Modern Node.js API Base URL
mypage.modern.api.url=https://api.modern-platform.axa.co.id

# Modern React Admin Base URL (used by the IFrame)
mypage.modern.admin.url=https://admin.modern-platform.axa.co.id
```

### Step 3.2: Gradle Build
Compile the Liferay workspace to generate the OSGi `.jar` bundles.
```bash
cd /path/to/my-page-liferay
./gradlew clean build -x test
```
*Note: Ensure the CI server has the correct AXA Artifactory SSL certificates installed to prevent Gradle dependency resolution failures.*

The primary artifact generated will be:
`modules/MypageAdminProduct/MypageAdminProduct-web/build/libs/com.mypage.admin.product.web-1.0.0.jar`

### Step 3.3: Linux VM Hot-Deploy
Use `scp`, `rsync`, or Ansible to transfer the compiled JAR file to the Liferay Linux VM.
```bash
# Transfer to the VM
scp com.mypage.admin.product.web-1.0.0.jar root@liferay-vm-prod:/tmp/

# Move to Liferay's hot-deploy directory
ssh root@liferay-vm-prod
mv /tmp/com.mypage.admin.product.web-1.0.0.jar /opt/liferay/osgi/modules/
```

### Step 3.4: Verification
Liferay's Apache Felix OSGi container will automatically detect the new JAR file, stop the old bundle, and start the new one.
1. **Tail the logs:** `tail -f /opt/liferay/logs/liferay*.log`
2. Look for the startup message from our custom component:
   `[DynamicProductPanelAppRegistrar] Successfully fetched X products from Modern API. Registering PanelApps...`
3. Log into the Liferay Control Panel as an Administrator.
4. Verify that the "Products" sidebar now dynamically lists the products fetched from the Node.js API.
5. Click a product and verify the IFrame correctly loads the React Admin UI.

---

## 4. Rollback Procedures

### OpenShift Rollback (Modern Platform)
If the Node.js API or React UI fails:
```bash
# Rollout undo to the previous deployment revision
oc rollout undo deployment/insurance-api
oc rollout undo deployment/insurance-admin
```

### Liferay Rollback (Linux VM)
If the Liferay OSGi bundle fails to start or causes portal instability:
1. SSH into the Liferay Linux VM.
2. Navigate to `/opt/liferay/osgi/modules/`.
3. Delete or move the problematic `.jar` file.
4. Replace it with the `.jar` file from the previous stable release. Liferay will automatically hot-deploy the older, stable version.
