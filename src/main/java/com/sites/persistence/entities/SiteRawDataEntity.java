package com.sites.persistence.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sites_raw_data")
public class SiteRawDataEntity {

    @Id
    private String id;
    @Column(name = "client_id")
    private Integer clientId;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "sub_project")
    private String subProject;
    @Column(name = "date_found")
    private Date dateFound;
    @Column(name = "date_live")
    private Date dateLive;
    private String status;
    @Column(name = "site_type")
    private String siteType;
    @Column(name = "domain_authority")
    private Integer domainAuthority;
    @Column(name = "site_traffic")
    private Long siteTraffic;
    @Column(name = "mention_type")
    private String mentionType;
    @Column(name = "commercial_link")
    private String commercialLink;
    @Column(name = "mention_acquisition")
    private String mentionAcquisition;
    @Column(name = "follow_type")
    private String followType;
    @Column(name = "site_name")
    private String siteName;
    @Column(name = "site_url")
    private String siteUrl;
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "topic_title")
    private String topicTitle;
    @Column(name = "primary_target_location")
    private String primaryTargetLocation;
    @Column(name = "placement_url")
    private String placementUrl;
    @Column(name = "primary_target_url")
    private String primaryTargetUrl;
    @Column(name = "target_link_type_1")
    private String targetLinkType1;
    @Column(name = "secondary_target_url")
    private String secondaryTargetUrl;
    @Column(name = "target_link_type_2")
    private String targetLinkType2;
    @Column(name = "tertiary_target_url")
    private String tertiaryTargetUrl;
    @Column(name = "target_link_type_3")
    private String targetLinkType3;
    @Column(name = "amount_paid")
    private String amountPaid;
    @Column(name = "link_radar_score")
    private String linkRadarScore;
    private Boolean enabled;
    private String notes;
    @Column(name = "date_created")
    private Date dateCreated;
    @Column(name = "date_updated")
    private Date dateUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSubProject() {
        return subProject;
    }

    public void setSubProject(String subProject) {
        this.subProject = subProject;
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

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
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
}
