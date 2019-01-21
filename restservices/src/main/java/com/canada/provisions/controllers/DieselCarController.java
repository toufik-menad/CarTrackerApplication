/*
 * Copyright (c) 2018, CGI.
 */
package com.canada.provisions.controllers;

import java.util.List;
import java.util.Optional;

import com.canada.provisions.dao.DieselCarRepository;
import com.canada.provisions.dto.DieselCar;
import com.canada.provisions.dto.ElectricCar;
import com.canada.provisions.entities.DieselCarEntity;
import com.canada.provisions.services.DieselCarService;
import com.canada.provisions.services.ElectricCarService;

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
@RequestMapping("dieselcar")
public class DieselCarController {
	
	
    private final Logger logger = LoggerFactory.getLogger(getClass());



    @Autowired
    DieselCarService dieselCarService;

    @PostMapping()
    public DieselCar create(@RequestBody final DieselCar dieselCar) {
        logger.info("enter create ...");
        return dieselCarService.createCar(dieselCar);
    }

    @PutMapping()
    public String update(@RequestBody final DieselCar dieselCar) {
        logger.info("enter update ...");
        return dieselCarService.serviceTires(dieselCar);
    }

    @GetMapping()
    public List<DieselCar> getAll() {
        return dieselCarService.getList();
    }
    
    
    @DeleteMapping(value="/{plate}")
    public void deleteCar(@PathVariable final String plate) {
    	logger.info("plate:{}",plate);
    	dieselCarService.deleteCar(plate);
    }
}
