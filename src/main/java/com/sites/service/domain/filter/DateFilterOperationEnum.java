package com.sites.service.domain.filter;

public enum DateFilterOperationEnum {
    EQUALS                      ("eq"),
    YEAR                        ("year"),
    MONTH                       ("month"),
    RANGE                       ("range");

    private String value;

    DateFilterOperationEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
