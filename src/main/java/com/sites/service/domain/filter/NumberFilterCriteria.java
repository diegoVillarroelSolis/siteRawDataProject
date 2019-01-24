package com.sites.service.domain.filter;

import com.sites.persistence.entities.SiteRawDataEntity;
import com.sites.persistence.specification.NumberSpecification;
import org.springframework.data.jpa.domain.Specification;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class NumberFilterCriteria extends FilterCriteria {

    @NotNull
    private Number value;
    @NotNull
    private NumberFilterOperationEnum filterOperationEnum;

    public NumberFilterCriteria(NumberFilterOperationEnum filterOperationEnum, Number value, String field) {
        super(field);
        this.value = value;
        this.filterOperationEnum = filterOperationEnum;
    }

    public NumberFilterCriteria() {
    }

    @Override
    public Specification<SiteRawDataEntity> specification() {
        return new NumberSpecification(this);
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public NumberFilterOperationEnum getFilterOperationEnum() {
        return filterOperationEnum;
    }

    public void setFilterOperationEnum(NumberFilterOperationEnum filterOperationEnum) {
        this.filterOperationEnum = filterOperationEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NumberFilterCriteria that = (NumberFilterCriteria) o;
        if (field.compareTo(that.field) != 0) {
            return false;
        }
        if (filterOperationEnum != that.filterOperationEnum) {
            return false;
        }
        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
