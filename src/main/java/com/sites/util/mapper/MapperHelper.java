package com.sites.util.mapper;

import org.mapstruct.factory.Mappers;

public abstract class MapperHelper {

    public static final SiteRawDataMapper SITE_DATA_MAPPER = Mappers.getMapper(SiteRawDataMapper.class);

}
