
package com.canada.provisions.dto;

import java.time.Year;

import org.springframework.stereotype.Component;

/**
 * @author T.Menad
 */
@Component
public class DieselCar {

    private String plate;

    private String make;

    private String model;

    private Year year;

    private int odometerReading;

    private String fuelType;
    
    public DieselCar() {
    	
    }

    /**
     * @param id
     * @param make
     * @param model
     * @param year
     * @param odometerReading
     * @param fuelType
     */
    public DieselCar(final String plate, final String make, final String model, final Year year, final int odometerReading, final String fuelType) {
        this.plate = plate;
        this.make = make;
        this.model = model;
        this.year = year;
        this.odometerReading = odometerReading;
        this.fuelType = fuelType;
    }

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public int getOdometerReading() {
		return odometerReading;
	}

	public void setOdometerReading(int odometerReading) {
		this.odometerReading = odometerReading;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

    
}
