/*
 * Copyright (c) 2018, CGI.
 */
package com.canada.provisions.services;

import com.canada.provisions.entities.DieselCarEntity;

/**
 * @author T.Menad
 */
public interface DieselCarService extends VehicleService<DieselCarEntity> {

    public String changeOil();

}
