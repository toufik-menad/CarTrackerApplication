/*
 * Copyright (c) 2018, CGI.
 */
package com.canada.provisions.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.canada.provisions.exceptions.NoCarFoundException;

/**
 * @author T.Menad
 */
@Component
public interface VehicleService<T> {

    /**creates a car in the database
     * @param car
     * @return
     */
    public T createCar(T car);

    /**deletes car from the database
     * @param plate
     */
    public void deleteCar(String plate);

    /**gets all instances from the database
     * @return
     */
    public List<T> getList();
    
    /**retrieves a car from the database based on the plate number
     * @param plate
     * @return
     * @throws NoCarFoundException
     */
    public T getById(final String plate) throws NoCarFoundException;

    /**services tires whenver it is needed
     * @param car
     * @return
     */
    public String serviceTires(T car);

    /**cleans up a car whenever needed based on the BR
     * @param car
     * @return
     */
    public String cleanBody(T car);

    /**raises a warning whenever a car engine needs to be serviced
     * @param car
     * @return
     */
    public String inspectEngine(T car);

}
