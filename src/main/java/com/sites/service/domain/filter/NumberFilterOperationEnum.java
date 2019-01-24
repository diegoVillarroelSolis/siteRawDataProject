package com.sites.service.domain.filter;

public enum NumberFilterOperationEnum {
    EQUALS                      ("eq");

    private String value;

    NumberFilterOperationEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
