
package com.canada.provisions.dto;

import java.time.Year;

/**
 * @author T.Menad
 */
public class DieselCar {

    private int id;

    private String make;

    private String model;

    private Year year;

    private int odometerReading;

    private String fuelType;

    /**
     * @param id
     * @param make
     * @param model
     * @param year
     * @param odometerReading
     * @param fuelType
     */
    public DieselCar(final int id, final String make, final String model, final Year year, final int odometerReading, final String fuelType) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.odometerReading = odometerReading;
        this.fuelType = fuelType;
    }

    /**
     * Getter for id.
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id.
     * 
     * @param id the id to set
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Getter for make.
     * 
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * Setter for make.
     * 
     * @param make the make to set
     */
    public void setMake(final String make) {
        this.make = make;
    }

    /**
     * Getter for model.
     * 
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Setter for model.
     * 
     * @param model the model to set
     */
    public void setModel(final String model) {
        this.model = model;
    }

    /**
     * Getter for year.
     * 
     * @return the year
     */
    public Year getYear() {
        return year;
    }

    /**
     * Setter for year.
     * 
     * @param year the year to set
     */
    public void setYear(final Year year) {
        this.year = year;
    }

    /**
     * Getter for odometerReading.
     * 
     * @return the odometerReading
     */
    public int getOdometerReading() {
        return odometerReading;
    }

    /**
     * Setter for odometerReading.
     * 
     * @param odometerReading the odometerReading to set
     */
    public void setOdometerReading(final int odometerReading) {
        this.odometerReading = odometerReading;
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
