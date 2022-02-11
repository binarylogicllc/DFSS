package com.ca.scheduler.core.domain.values;

public enum CustomerType {

    CUSTOMER_MOG("MOG"), ALMAHA("ALMAHA"), FUEL_PAY("FUEL_PAY");

    private String suffix;

    CustomerType(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }
}
