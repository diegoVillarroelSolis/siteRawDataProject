package com.sites.persistence.specification;

import com.sites.service.domain.filter.StringFilterCriteria;
import com.sites.persistence.entities.SiteRawDataEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Objects;

public class StringSpecification implements Specification<SiteRawDataEntity> {

    protected StringFilterCriteria criteria;

    public StringSpecification(StringFilterCriteria stringFilterCriteria) {
        this.criteria = stringFilterCriteria;
    }

    @Override
    public Predicate toPredicate(Root<SiteRawDataEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate result = null;
        switch (criteria.getFilterOperationEnum()) {
            case EQUALS:
                result = criteriaBuilder.equal(root.get(criteria.getField()), criteria.getValue());
                break;
            case EQUALS_IGNORE_CASE:
                result = criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get(criteria.getField())), criteria.getValue().toLowerCase());
                break;
            case CONTAINS:
                result = criteriaBuilder.like(root.get(criteria.getField()), "%" + criteria.getValue() + "%");
                break;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringSpecification that = (StringSpecification) o;
        return Objects.equals(criteria, that.criteria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(criteria);
    }
}
