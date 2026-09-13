# mybiz.axa.co.id

This repository contains the Liferay-based MyPage application. The build is powered by Gradle and produces OSGi jars and web artifacts which are deployed to a Liferay server.

## Building locally

A Gradle wrapper is provided so you don't need a global Gradle installation.

```bash
# clean and compile everything
./gradlew clean build

# produce a single bundle containing all jar/war outputs
./gradlew -PreleaseVersion=1.2.3 releaseBundle
# artifacts will be placed under build/release/
```

The `releaseBundle` task is optional; it collects all of the
`build/libs/*.jar` and `build/libs/*.war` files from subprojects into a
ZIP file. Omit `-PreleaseVersion` to embed `local` in the filename.

## Automated release via Jenkins

All builds and artifact publication are handled by our Jenkins
infrastructure; GitHub Actions are **not** used. The `Jenkinsfile` in this
repo performs a full Gradle build and – when a `RELEASE_TAG` parameter is
provided – produces a zip bundle and pushes it into Artifactory
(`axa-magi-id_main`).

### Jenkins pipeline

The `Jenkinsfile` performs a full Gradle build (no local Gradle
installation is required) and includes an **optional release stage** which
can be triggered manually using a `RELEASE_TAG` parameter.

The basic workflow is:

1. Tag the desired commit with a version (e.g. `v1.0.0`) and push the tag.
2. Run the Jenkins job, providing `RELEASE_TAG=v1.0.0` when prompted.
3. The pipeline builds the project and creates a ZIP bundle under
   `build/release/`.
4. If `RELEASE_TAG` is set the bundle is uploaded to Artifactory using the
   `ARTIFACTORY_CRED_ID` credentials.

Supplying an empty `RELEASE_TAG` simply skips the release stage, allowing
Jenkins to be used for development builds as before.

To publish a release from Jenkins:

1. Ensure the job has an Artifactory credential and that
   `ARTIFACTORY_CRED_ID` in the Jenkinsfile points to it.
2. Create a git tag on the commit you wish to release, following the
   `vX.Y.Z` pattern, then push it to the repository.
3. Run the Jenkins job and provide the tag value in the `RELEASE_TAG`
   parameter, e.g. `v1.0.0`.
4. The pipeline will build the project, create a ZIP bundle under
   `build/release/`, and push the artifact to Artifactory:

   ```groovy
   withCredentials([usernamePassword(
       credentialsId: env.ARTIFACTORY_CRED_ID,
       usernameVariable: 'ART_USER',
       passwordVariable: 'ART_PASSWORD'
   )]) {
       sh '''
           curl -u${ART_USER}:${ART_PASSWORD} -T "${FILE}" \
                "https://artifactory.asia.axa-cloud.com/artifactory/axa-magi-id_main/${FILE}"
       '''
   }
   ```

   Remove/comment out this section if you do not want Artifactory uploads.

If you prefer automatic tagging, you can modify the pipeline to derive
`RELEASE_TAG` from `env.GIT_TAG_NAME` or similar.

> **Note:** the pipeline still works as before for standard builds;
> supplying an empty `RELEASE_TAG` simply skips the release stage.

