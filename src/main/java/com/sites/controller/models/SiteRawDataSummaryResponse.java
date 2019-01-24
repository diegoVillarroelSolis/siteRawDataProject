package com.sites.controller.models;

import java.util.ArrayList;
import java.util.List;

public class SiteRawDataSummaryResponse {

    private List<SiteRawDataSummary> siteRawDataSummary;
    private int totalPages;
    private int totalPagesSize;

    public SiteRawDataSummaryResponse(List<SiteRawDataSummary> siteRawDataSummary, int totalPages, int totalPagesSize) {
        this.siteRawDataSummary = siteRawDataSummary;
        this.totalPages = totalPages;
        this.totalPagesSize = totalPagesSize;
    }

    public SiteRawDataSummaryResponse() {
        siteRawDataSummary = new ArrayList<>();
    }

    public List<SiteRawDataSummary> getSiteRawDataSummary() {
        return siteRawDataSummary;
    }

    public void setSiteRawDataSummary(List<SiteRawDataSummary> siteRawDataSummary) {
        this.siteRawDataSummary = siteRawDataSummary;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalPagesSize() {
        return totalPagesSize;
    }

    public void setTotalPagesSize(int totalPagesSize) {
        this.totalPagesSize = totalPagesSize;
    }
}
