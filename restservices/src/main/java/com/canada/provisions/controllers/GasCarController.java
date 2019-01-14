/*
 * Copyright (c) 2018, CGI.
 */
package com.canada.provisions.controllers;

import java.util.List;
import java.util.Optional;

import com.canada.provisions.dao.GasCarRepository;
import com.canada.provisions.dto.ElectricCar;
import com.canada.provisions.dto.GasCar;
import com.canada.provisions.entities.DieselCarEntity;
import com.canada.provisions.entities.GasCarEntity;
import com.canada.provisions.services.ElectricCarService;
import com.canada.provisions.services.GasCarService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author T.Menad
 */
@RestController
@RequestMapping("gascar")
public class GasCarController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    GasCarService gasCarService;


    // We can use GasCarServiceImp here
    
    
    @DeleteMapping(value="/{plate}")
    public void deleteCar(@PathVariable final String plate) {
    	logger.info("plate:{}",plate);
    	gasCarService.deleteCar(plate);
    }


}
