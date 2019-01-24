package com.sites.service.domain.filter;

public enum StringFilterOperationEnum {
    EQUALS                      ("eq"),
    CONTAINS					("like"),
    EQUALS_IGNORE_CASE          ("eqic");

    private String value;

    StringFilterOperationEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
