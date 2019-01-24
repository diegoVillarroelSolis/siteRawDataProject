package com.sites.service.domain.filter;

import com.sites.persistence.entities.SiteRawDataEntity;
import com.sites.persistence.specification.DateSpecification;
import org.springframework.data.jpa.domain.Specification;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

public class DateFilterCriteria extends FilterCriteria {

    @NotNull
    @NotEmpty
    private Date startDate;
    private Date endDate;
    @NotNull
    @NotEmpty
    private DateFilterOperationEnum filterOperationEnum;

    public DateFilterCriteria(DateFilterOperationEnum filterOperationEnum,
                              Date startDate, Date endDate,
                              String field) {
        super(field);
        this.startDate = startDate;
        this.endDate = endDate;
        this.filterOperationEnum = filterOperationEnum;
    }

    public DateFilterCriteria() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public DateFilterOperationEnum getFilterOperationEnum() {
        return filterOperationEnum;
    }

    public void setFilterOperationEnum(DateFilterOperationEnum filterOperationEnum) {
        this.filterOperationEnum = filterOperationEnum;
    }

    @Override
    public Specification<SiteRawDataEntity> specification() {
        return new DateSpecification(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateFilterCriteria that = (DateFilterCriteria) o;
        return Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }
}
