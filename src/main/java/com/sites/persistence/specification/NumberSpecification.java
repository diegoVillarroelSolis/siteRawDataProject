package com.sites.persistence.specification;

import com.sites.service.domain.filter.NumberFilterCriteria;
import com.sites.persistence.entities.SiteRawDataEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Objects;

public class NumberSpecification implements Specification<SiteRawDataEntity> {
    protected NumberFilterCriteria criteria;

    public NumberSpecification(NumberFilterCriteria criteria) {
        this.criteria = criteria;
    }

    public Predicate toPredicate(Root<SiteRawDataEntity> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {
        Predicate result = null;
        switch (criteria.getFilterOperationEnum()) {
            case EQUALS:
                result = criteriaBuilder.equal(root.get(criteria.getField()), criteria.getValue());
                break;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberSpecification that = (NumberSpecification) o;
        return Objects.equals(criteria, that.criteria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(criteria);
    }
}
