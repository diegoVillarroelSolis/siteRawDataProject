package com.sites.service.domain.filter;

import com.sites.persistence.entities.SiteRawDataEntity;
import com.sites.persistence.specification.StringSpecification;
import org.springframework.data.jpa.domain.Specification;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class StringFilterCriteria extends FilterCriteria {

    @NotNull
    @NotEmpty
    private String value;
    @NotNull
    @NotEmpty
    private StringFilterOperationEnum filterOperationEnum;

    public StringFilterCriteria(StringFilterOperationEnum filterOperationEnum,
                                String value,
                                String field) {
        super(field);
        this.value = value;
        this.filterOperationEnum = filterOperationEnum;
    }

    public StringFilterCriteria() {
    }

    @Override
    public Specification<SiteRawDataEntity> specification() {
        return new StringSpecification(this);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StringFilterOperationEnum getFilterOperationEnum() {
        return filterOperationEnum;
    }

    public void setFilterOperationEnum(StringFilterOperationEnum filterOperationEnum) {
        this.filterOperationEnum = filterOperationEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringFilterCriteria that = (StringFilterCriteria) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
