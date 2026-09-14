package com.mypage.agencyportal.dto.mobileapps;

public class VersionDto {

    private boolean status;
    private String message;
    private VersionData data;

    public VersionDto(boolean status, String message, VersionData data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public VersionData getData() {
        return data;
    }

    // Inner DTO class untuk "data"
    public static class VersionData {
        private PlatformVersion android;
        private PlatformVersion ios;

        public VersionData(PlatformVersion android, PlatformVersion ios) {
            this.android = android;
            this.ios = ios;
        }

        public PlatformVersion getAndroid() {
            return android;
        }

        public PlatformVersion getIos() {
            return ios;
        }
    }

    // Inner DTO class untuk "android"/"ios"
    public static class PlatformVersion {
        private String latest_version;

        public PlatformVersion(String latest_version) {
            this.latest_version = latest_version;
        }

        public String getLatest_version() {
            return latest_version;
        }
    }
}