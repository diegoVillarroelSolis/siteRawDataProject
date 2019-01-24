package com.sites.controller.models;

import java.util.ArrayList;
import java.util.List;

public class SiteRawDataResponse {
    private List<SiteRawData> siteRawData;
    private int totalPages;
    private int totalElements;

    public SiteRawDataResponse(List<SiteRawData> siteRawData, int totalPages, int totalElements) {
        this.siteRawData = siteRawData;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public SiteRawDataResponse() {
        siteRawData = new ArrayList<>();
    }

    public List<SiteRawData> getSiteRawData() {
        return siteRawData;
    }

    public void setSiteRawData(List<SiteRawData> siteRawData) {
        this.siteRawData = siteRawData;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }
}
