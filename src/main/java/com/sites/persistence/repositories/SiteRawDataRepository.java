package com.sites.persistence.repositories;

import com.sites.persistence.entities.SiteRawDataEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SiteRawDataRepository extends PagingAndSortingRepository<SiteRawDataEntity, String>,
        JpaSpecificationExecutor<SiteRawDataEntity> {
}
