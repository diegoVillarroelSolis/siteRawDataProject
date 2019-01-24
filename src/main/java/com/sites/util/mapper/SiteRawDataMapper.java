package com.sites.util.mapper;

import com.sites.controller.models.SiteRawDataSummary;
import com.sites.controller.models.SiteRawData;
import com.sites.persistence.entities.SiteRawDataEntity;
import org.mapstruct.Mapper;

@Mapper()
public interface SiteRawDataMapper {

    SiteRawData convertToSiteRawData(SiteRawDataEntity entity);

    SiteRawDataSummary convertToSiteRawDataSummary(SiteRawDataEntity entity);

    SiteRawDataSummary convertToSiteRawDataSummary(SiteRawData siteRawData);
}
