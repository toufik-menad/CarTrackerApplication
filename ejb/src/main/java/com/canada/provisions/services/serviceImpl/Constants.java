/*
 * Copyright (c) 2018, CGI.
 */
package com.canada.provisions.services.serviceImpl;

/**
 * @author T.Menad
 */
public enum Constants {

    TIRESERVICE(20000), CLEANINGSERVICE(1000), BATTERYCHARGE(1000), INSPECTENGINE(15000),

    OILSERVICE(10000);

    private int value;

    Constants(final int value) {
        this.value = value;
    }

    /**
     * Getter for value.
     * 
     * @return the value
     */
    public int getValue() {
        return value;
    }

}
