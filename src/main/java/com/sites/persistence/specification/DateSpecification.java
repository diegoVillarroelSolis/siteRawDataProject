package com.sites.persistence.specification;

import com.sites.service.domain.filter.DateFilterCriteria;
import com.sites.persistence.entities.SiteRawDataEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

public class DateSpecification implements Specification<SiteRawDataEntity> {

    private DateFilterCriteria criteria;

    public DateSpecification(DateFilterCriteria dateFilterCriteria) {
        this.criteria = dateFilterCriteria;
    }

    @Override
    public Predicate toPredicate(Root<SiteRawDataEntity> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {
        Predicate predicate = null;
        Instant instant = criteria.getStartDate().toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate startDate = zdt.toLocalDate();

        switch (criteria.getFilterOperationEnum()) {
            case EQUALS:
                predicate = criteriaBuilder.equal(root.get(criteria.getField()), criteria.getStartDate());
                break;
            case YEAR:
                predicate = criteriaBuilder.equal(
                        criteriaBuilder.function("YEAR", Integer.class, root.get(criteria.getField())),
                        startDate.getYear());
                break;
            case MONTH:
                predicate = criteriaBuilder.equal(
                        criteriaBuilder.function("MONTH", Integer.class, root.get(criteria.getField())),
                        startDate.getMonthValue());
                break;
            case RANGE:
                predicate = criteriaBuilder.between(root.get(criteria.getField()), criteria.getStartDate(),
                        criteria.getEndDate());
                break;
        }
        return predicate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateSpecification that = (DateSpecification) o;
        return Objects.equals(criteria, that.criteria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(criteria);
    }
}
