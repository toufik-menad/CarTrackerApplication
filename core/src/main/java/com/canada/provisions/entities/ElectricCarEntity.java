/**
 * 
 */
package com.canada.provisions.entities;

import java.time.Year;

import javax.persistence.Entity;

/**
 * @author MENAD
 */
@Entity
public class ElectricCarEntity extends AbstractVehicleEntity {

    private int autonomy;

    public ElectricCarEntity() {
    }

    public ElectricCarEntity(final int id, final String make, final String model, final Year year, final int odometerReading,
            final int autonomy) {
        super(id, make, model, year, odometerReading);
        this.autonomy = autonomy;
    }

    /**
     * @return the autonomy
     */
    public int getAutonomy() {
        return autonomy;
    }

    /**
     * @param autonomy the autonomy to set
     */
    public void setAutonomy(final int autonomy) {
        this.autonomy = autonomy;
    }

}
