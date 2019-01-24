package com.sites.controller.models;

import com.sites.service.domain.filter.FilterCriteria;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class SearchRequest {

    @NotNull
    @NotEmpty
    @Valid
    private List<FilterCriteria> filterCriteriaList;

    public SearchRequest() {
    }

    public List<FilterCriteria> getFilterCriteriaList() {
        return filterCriteriaList;
    }

    public void setFilterCriteriaList(List<FilterCriteria> filterCriteriaList) {
        this.filterCriteriaList = filterCriteriaList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchRequest that = (SearchRequest) o;
        return Objects.equals(filterCriteriaList, that.filterCriteriaList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filterCriteriaList);
    }
}
