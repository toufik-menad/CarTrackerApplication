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
public class DieselCarEntity extends AbstractVehicleEntity {

    private String fuelType;

    public DieselCarEntity() {

    }

    public DieselCarEntity(final int id, final String make, final String model, final Year year, final int odometerReading,
            final String fuelType) {
        super(id, make, model, year, odometerReading);
        this.fuelType = fuelType;

    }

    /**
     * Getter for fuelType.
     * 
     * @return the fuelType
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * Setter for fuelType.
     * 
     * @param fuelType the fuelType to set
     */
    public void setFuelType(final String fuelType) {
        this.fuelType = fuelType;
    }

}
