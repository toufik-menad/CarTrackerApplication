/**
 * 
 */
package com.canada.provisions.entities;

import java.time.Instant;
import java.time.Year;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author MENAD
 */
@Entity(name = "Entity")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class AbstractVehicleEntity {

    @Id
    @Column(name = "plate", unique = true, nullable=false)
    private String plate;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Year year;

    @Column(name = "odometerReading")
    private int odometerReading;

    @Column()
    private String creationAuthor;

    @Temporal(TemporalType.DATE)
    @Column()
    private Date creationDate;

    @Column()
    private String updateAuthor;

    @Temporal(TemporalType.DATE)
    @Column()
    private Date lastUpdateDate;

    /**
     * default constructor for Jackson
     */
    public AbstractVehicleEntity() {
    }

    /**
     * @param id
     * @param make
     * @param model
     * @param year
     * @param odometerReading
     */
    public AbstractVehicleEntity(final String plate, final String make, final String model, final Year year, final int odometerReading) {
        this.plate = plate;
        this.make = make;
        this.model = model;
        this.year = year;
        this.odometerReading = odometerReading;
    }

    

    public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	/**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(final String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(final String model) {
        this.model = model;
    }

    /**
     * @return the year
     */
    public Year getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(final Year year) {
        this.year = year;
    }

    /**
     * @return the odometerReading
     */
    public int getOdometerReading() {
        return odometerReading;
    }

    /**
     * @param odometerReading the odometerReading to set
     */
    public void setOdometerReading(final int odometerReading) {
        this.odometerReading = odometerReading;
    }

    /**
     * @return the creation_author
     */
    public String getCreationAuthor() {
        return creationAuthor;
    }

    /**
     * @param creation_author the creation_author to set
     */
    public void setCreationAuthor(final String creation_author) {
        this.creationAuthor = creation_author;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the updateAuthor
     */
    public String getUpdateAuthor() {
        return updateAuthor;
    }

    /**
     * @param updateAuthor the updateAuthor to set
     */
    public void setUpdateAuthor(final String updateAuthor) {
        this.updateAuthor = updateAuthor;
    }

    /**
     * @return the lastUpdateDate
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * @param lastUpdateDate the lastUpdateDate to set
     */
    public void setLastUpdateDate(final Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @PrePersist
    private void prePersist() {
        this.creationDate = Date.from(Instant.now());
        this.creationAuthor = "getUserFromAuthentication";
    }

    @PreUpdate
    private void preUpdate() {
        this.lastUpdateDate = Date.from(Instant.now());
        this.updateAuthor = "getUserFromAuthentication";
    }

}