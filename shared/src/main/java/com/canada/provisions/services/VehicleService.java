/*
 * Copyright (c) 2018, CGI.
 */
package com.canada.provisions.services;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author T.Menad
 */
@Component
public interface VehicleService<T> {

    public T createCar(T car);

    public void deleteCar(int id);

    public List<T> getList();

    public String serviceTires(T car);

    public String cleanBody(T car);

    public String inspectEngine(T car);

}
