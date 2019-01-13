/*
 * Copyright (c) 2018, CGI.
 */
package com.canada.provisions.services;

import com.canada.provisions.dto.ElectricCar;

/**
 * @author T.Menad
 */
public interface ElectricCarService extends VehicleService<ElectricCar> {

    /**
     * simple method to remind driver batteries are low and need to be charged
     * 
     * @return
     */
    public String chargeBatteries(final ElectricCar car);

}
