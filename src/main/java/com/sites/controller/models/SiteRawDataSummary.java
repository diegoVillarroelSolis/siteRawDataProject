package com.sites.controller.models;

import java.util.Objects;

public class SiteRawDataSummary {
    private String projectName;
    private boolean status;
    private String siteType;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteRawDataSummary that = (SiteRawDataSummary) o;
        return status == that.status &&
                Objects.equals(projectName, that.projectName) &&
                Objects.equals(siteType, that.siteType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, status, siteType);
    }
}
