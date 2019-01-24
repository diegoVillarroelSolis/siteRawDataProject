package com.sites.service.domain.filter;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.sites.persistence.entities.SiteRawDataEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@Type(value = NumberFilterCriteria.class, name = "number"),
               @Type(value = StringFilterCriteria.class, name = "string"),
               @Type(value = DateFilterCriteria.class, name = "date"),
              })
public abstract class FilterCriteria {
    @NotNull
    @NotEmpty
    protected String field;

    public FilterCriteria(String field) {
        this.field = field;
    }

    public FilterCriteria() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public abstract Specification<SiteRawDataEntity> specification();
}
