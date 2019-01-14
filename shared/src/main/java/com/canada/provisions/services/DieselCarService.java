/*
 * Copyright (c) 2018, CGI.
 */
package com.canada.provisions.services;

import org.springframework.stereotype.Service;

import com.canada.provisions.dto.DieselCar;


/**
 * @author T.Menad
 */
@Service
public interface DieselCarService extends VehicleService<DieselCar> {

    public String changeOil(DieselCar car);

}
