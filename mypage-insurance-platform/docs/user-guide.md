# MyPage Insurance Product Wizard — User Guide

Welcome to the internal Product Wizard! This tool allows the AXA Product Team to easily configure, manage, and publish new insurance products directly to the MyPage Liferay portal.

## Getting Started

1. **Access the Portal**: Open the Admin Portal at https://admin-insurance.axa-cloud.com (or http://localhost:5173 for local development).
2. **Login**: Click "Login with OneAccount". You must have the product-admin role assigned to your OneAccount profile to make changes.

## Dashboard Overview

The dashboard provides a quick glance at:
- **Active Products**: Products currently live on the platform.
- **Drafts in Progress**: Products you are actively configuring but haven't published yet.
- **Liferay Sync Status**: A summary of products pulled directly from Liferay.

## Creating a New Product

Click **Add New Product** from the sidebar or dashboard. The creation process is divided into 6 intuitive steps:

### Step 1: Identity
- **Name & Code**: Enter the human-readable product name and an internal code (used for API references).
- **Type**: Select the category (e.g., Property, Motor, Health).
- **Distribution Channels**: Toggle whether the product is B2C, B2B, or B2B2C.
- *Note*: A draft is automatically saved as soon as you proceed to the next step.

### Step 2: Plans & Benefits
- **Create Plans**: Add different tiers (e.g., Basic, Standard, Comprehensive).
- **Add Benefits**: Under each plan, list the specific coverages, values, and whether they should be highlighted in the UI.
- **Reorder**: Drag and drop plans and benefits to adjust their display order.

### Step 3: Rate Table
- **Variables**: Define rating variables (e.g., "Building Type", "Occupancy Zone").
- **Matrix**: Generate a pricing matrix based on your variables and fill in the rate multipliers for each combination.

### Step 4: Form Schema Builder
- **Drag & Drop**: Build the customer purchase flow visually by dragging fields from the left palette onto the center canvas.
- **Configure Fields**: Click any field to set its label, placeholder, and whether it is required.
- **Dynamic Lists**: For Dropdown fields, you can link them directly to Liferay Master Data (e.g., Provinces, Cities, Occupations).

### Step 5: Admin Configuration
- Set backend financial parameters: Commission percentages, Stamp Duties, Policy Costs.
- Toggle PEP (Politically Exposed Person) screening.
- Upload Policy Wording PDF documents.

### Step 6: Review & Publish
- Review a summary of your configuration.
- Click **Save as Draft** to come back later, or **Publish Product** to immediately push the configuration to the active database.

## Editing & Syncing with Liferay

### Liferay-Managed Products
Products marked with a "Liferay" badge are synchronized from the legacy JSONWS Liferay system.
- You can view their configuration, but schema and plan structural changes must be done by developers.
- You can update financial configurations (Stamp Duty, Commission) directly through the wizard.

### Manual Sync
If a product was updated directly in Liferay, you can force a sync by clicking the "Sync with Liferay" button on the Dashboard.

## Troubleshooting
- **Cannot publish**: Ensure you have filled out all required fields marked with an asterisk (*).
- **Login fails**: Verify with IT that your OneAccount profile has the product-admin role.
