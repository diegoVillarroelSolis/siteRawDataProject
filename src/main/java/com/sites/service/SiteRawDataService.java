package com.sites.service;

import com.sites.controller.models.*;
import com.sites.persistence.entities.SiteRawDataEntity;
import com.sites.persistence.repositories.SiteRawDataRepository;
import com.sites.service.domain.filter.FilterCriteria;
import com.sites.util.mapper.MapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiteRawDataService {

    private SiteRawDataRepository siteRawDataRepository;

    @Autowired
    public SiteRawDataService(SiteRawDataRepository siteRawDataRepository) {
        this.siteRawDataRepository = siteRawDataRepository;
    }

    public Page<SiteRawData> findSiteRawData(Pageable page) {
        Page<SiteRawDataEntity> siteRawDataResult = siteRawDataRepository.findAll(page);
        Page<SiteRawData> siteRawDataPageResult = new PageImpl<>(new ArrayList<>());
        if (siteRawDataResult != null) {
            siteRawDataPageResult = siteRawDataResult.map(MapperHelper.SITE_DATA_MAPPER::convertToSiteRawData);
        }
        return siteRawDataPageResult;
    }

    public Page<SiteRawDataSummary> findSiteRawDataSummary(Pageable page) {
        Page<SiteRawDataEntity> siteRawDataResult = siteRawDataRepository.findAll(page);
        Page<SiteRawDataSummary> siteRawDataPageResult = new PageImpl<>(new ArrayList<>());
        if (siteRawDataResult != null) {
            siteRawDataPageResult = siteRawDataResult.map(MapperHelper.SITE_DATA_MAPPER::convertToSiteRawDataSummary);
        }
        return siteRawDataPageResult;
    }

    public Page<SiteRawData> findSiteRawDataByCriteria(List<FilterCriteria> filterCriteriaList, Pageable pageRequest) {
        List<SiteRawData> siteRawData = new ArrayList<>();
        Page<SiteRawDataEntity> siteRawDataEntities;
        Specification<SiteRawDataEntity> specification = null;

        if(!filterCriteriaList.isEmpty()) {
            specification = filterCriteriaList.get(0).specification();
            for ( int i=1 ; i<filterCriteriaList.size() ; i++ ) {
                specification = Specification.where(specification)
                        .and(filterCriteriaList.get(i).specification());
            }
        }

        siteRawDataEntities = siteRawDataRepository.findAll(specification, pageRequest);
        siteRawDataEntities.forEach(
                e -> siteRawData.add(MapperHelper.SITE_DATA_MAPPER.convertToSiteRawData(e)));
        return new PageImpl<>(siteRawData, pageRequest, siteRawDataEntities.getTotalElements());
    }
}
