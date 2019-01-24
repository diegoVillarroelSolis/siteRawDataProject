package com.sites.controller.models;

import java.util.Date;
import java.util.Objects;

public class SiteRawData {

    private String projectName;
    private String subProjectName;
    private Date dateFound;
    private Date dateLive;
    private String status;
    private String siteType;
    private Integer domainAuthority;
    private Long siteTraffic;
    private String mentionType;
    private String commercialLink;
    private String mentionAcquisition;
    private String followType;
    private String siteName;
    private String siteUrl;
    private String contentType;
    private String topicTitle;
    private String primaryTargetLocation;
    private String placementUrl;
    private String primaryTargetUrl;
    private String targetLinkType1;
    private String secondaryTargetUrl;
    private String targetLinkType2;
    private String tertiaryTargetUrl;
    private String targetLinkType3;
    private double amountPaid;
    private String linkRadarScore;
    private Boolean enabled;
    private String notes;
    private Date dateCreated;
    private Date dateUpdated;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSubProjectName() {
        return subProjectName;
    }

    public void setSubProjectName(String subProjectName) {
        this.subProjectName = subProjectName;
    }

    public Date getDateFound() {
        return dateFound;
    }

    public void setDateFound(Date dateFound) {
        this.dateFound = dateFound;
    }

    public Date getDateLive() {
        return dateLive;
    }

    public void setDateLive(Date dateLive) {
        this.dateLive = dateLive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public Integer getDomainAuthority() {
        return domainAuthority;
    }

    public void setDomainAuthority(Integer domainAuthority) {
        this.domainAuthority = domainAuthority;
    }

    public Long getSiteTraffic() {
        return siteTraffic;
    }

    public void setSiteTraffic(Long siteTraffic) {
        this.siteTraffic = siteTraffic;
    }

    public String getMentionType() {
        return mentionType;
    }

    public void setMentionType(String mentionType) {
        this.mentionType = mentionType;
    }

    public String getCommercialLink() {
        return commercialLink;
    }

    public void setCommercialLink(String commercialLink) {
        this.commercialLink = commercialLink;
    }

    public String getMentionAcquisition() {
        return mentionAcquisition;
    }

    public void setMentionAcquisition(String mentionAcquisition) {
        this.mentionAcquisition = mentionAcquisition;
    }

    public String getFollowType() {
        return followType;
    }

    public void setFollowType(String followType) {
        this.followType = followType;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getPrimaryTargetLocation() {
        return primaryTargetLocation;
    }

    public void setPrimaryTargetLocation(String primaryTargetLocation) {
        this.primaryTargetLocation = primaryTargetLocation;
    }

    public String getPlacementUrl() {
        return placementUrl;
    }

    public void setPlacementUrl(String placementUrl) {
        this.placementUrl = placementUrl;
    }

    public String getPrimaryTargetUrl() {
        return primaryTargetUrl;
    }

    public void setPrimaryTargetUrl(String primaryTargetUrl) {
        this.primaryTargetUrl = primaryTargetUrl;
    }

    public String getTargetLinkType1() {
        return targetLinkType1;
    }

    public void setTargetLinkType1(String targetLinkType1) {
        this.targetLinkType1 = targetLinkType1;
    }

    public String getSecondaryTargetUrl() {
        return secondaryTargetUrl;
    }

    public void setSecondaryTargetUrl(String secondaryTargetUrl) {
        this.secondaryTargetUrl = secondaryTargetUrl;
    }

    public String getTargetLinkType2() {
        return targetLinkType2;
    }

    public void setTargetLinkType2(String targetLinkType2) {
        this.targetLinkType2 = targetLinkType2;
    }

    public String getTertiaryTargetUrl() {
        return tertiaryTargetUrl;
    }

    public void setTertiaryTargetUrl(String tertiaryTargetUrl) {
        this.tertiaryTargetUrl = tertiaryTargetUrl;
    }

    public String getTargetLinkType3() {
        return targetLinkType3;
    }

    public void setTargetLinkType3(String targetLinkType3) {
        this.targetLinkType3 = targetLinkType3;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getLinkRadarScore() {
        return linkRadarScore;
    }

    public void setLinkRadarScore(String linkRadarScore) {
        this.linkRadarScore = linkRadarScore;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteRawData that = (SiteRawData) o;
        return Double.compare(that.amountPaid, amountPaid) == 0 &&
                Objects.equals(projectName, that.projectName) &&
                Objects.equals(subProjectName, that.subProjectName) &&
                Objects.equals(dateFound, that.dateFound) &&
                Objects.equals(dateLive, that.dateLive) &&
                Objects.equals(status, that.status) &&
                Objects.equals(siteType, that.siteType) &&
                Objects.equals(domainAuthority, that.domainAuthority) &&
                Objects.equals(siteTraffic, that.siteTraffic) &&
                Objects.equals(mentionType, that.mentionType) &&
                Objects.equals(commercialLink, that.commercialLink) &&
                Objects.equals(mentionAcquisition, that.mentionAcquisition) &&
                Objects.equals(followType, that.followType) &&
                Objects.equals(siteName, that.siteName) &&
                Objects.equals(siteUrl, that.siteUrl) &&
                Objects.equals(contentType, that.contentType) &&
                Objects.equals(topicTitle, that.topicTitle) &&
                Objects.equals(primaryTargetLocation, that.primaryTargetLocation) &&
                Objects.equals(placementUrl, that.placementUrl) &&
                Objects.equals(primaryTargetUrl, that.primaryTargetUrl) &&
                Objects.equals(targetLinkType1, that.targetLinkType1) &&
                Objects.equals(secondaryTargetUrl, that.secondaryTargetUrl) &&
                Objects.equals(targetLinkType2, that.targetLinkType2) &&
                Objects.equals(tertiaryTargetUrl, that.tertiaryTargetUrl) &&
                Objects.equals(targetLinkType3, that.targetLinkType3) &&
                Objects.equals(linkRadarScore, that.linkRadarScore) &&
                Objects.equals(enabled, that.enabled) &&
                Objects.equals(notes, that.notes) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(dateUpdated, that.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                projectName,
                subProjectName,
                dateFound,
                dateLive,
                status,
                siteType,
                domainAuthority,
                siteTraffic,
                mentionType,
                commercialLink,
                mentionAcquisition,
                followType,
                siteName,
                siteUrl,
                contentType,
                topicTitle,
                primaryTargetLocation,
                placementUrl,
                primaryTargetUrl,
                targetLinkType1,
                secondaryTargetUrl,
                targetLinkType2,
                tertiaryTargetUrl,
                targetLinkType3,
                amountPaid,
                linkRadarScore,
                enabled,
                notes,
                dateCreated,
                dateUpdated);
    }
}
