/*
 * Copyright (c) 2018, CGI.
 */
package com.canada.provisions.entities;

import java.time.Year;

import javax.persistence.Entity;

/**
 * @author T.Menad
 */
@Entity
public class GasCarEntity extends AbstractVehicleEntity {

    private int gears;

    public GasCarEntity() {

    }

    public GasCarEntity(final String plate, final String make, final String model, final Year year, final int odometerReading, final int gears) {
        super(plate, make, model, year, odometerReading);
        this.gears = gears;

    }

    /**
     * Getter for gears.
     * 
     * @return the gears
     */
    public int getGears() {
        return gears;
    }

    /**
     * Setter for gears.
     * 
     * @param gears the gears to set
     */
    public void setGears(final int gears) {
        this.gears = gears;
    }

}
