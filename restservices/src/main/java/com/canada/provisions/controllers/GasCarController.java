/*
 * Copyright (c) 2018, CGI.
 */
package com.canada.provisions.controllers;

import java.util.List;
import com.canada.provisions.dto.GasCar;
import com.canada.provisions.services.GasCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author T.Menad
 */
@RestController
@RequestMapping("gascar")
public class GasCarController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    GasCarService gasCarService;

    @CrossOrigin
    @GetMapping()
    public List<GasCar> getAll() {
        return gasCarService.getList();
    }

    // We can use GasCarServiceImp here
    @CrossOrigin
    @PostMapping()
    public GasCar create(@RequestBody final GasCar gasCar) {
        logger.info("enter create ...");
        return gasCarService.createCar(gasCar);
    }
    
    
    @DeleteMapping(value="/{plate}")
    public void deleteCar(@PathVariable final String plate) {
    	logger.info("plate:{}",plate);
    	gasCarService.deleteCar(plate);
    }


}
