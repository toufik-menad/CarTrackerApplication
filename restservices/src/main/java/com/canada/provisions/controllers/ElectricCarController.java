/**
 * 
 */
package com.canada.provisions.controllers;

import java.util.List;

import com.canada.provisions.dto.ElectricCar;
import com.canada.provisions.services.ElectricCarService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MENAD
 */
@RestController
@RequestMapping("electriccar")
public class ElectricCarController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ElectricCarService electricCarService;

    @CrossOrigin
    @PostMapping()
    public ElectricCar create(@RequestBody final ElectricCar electricCar) {
        logger.info("enter create ...");
        return electricCarService.createCar(electricCar);
    }

    @PutMapping()
    public String update(@RequestBody final ElectricCar electricCar) {
        logger.info("enter update ...");
        return electricCarService.serviceTires(electricCar);
    }

    @CrossOrigin
    @GetMapping()
    public List<ElectricCar> getAll() {
        return electricCarService.getList();
    }
    
    
    @DeleteMapping(value="/{plate}")
    public void deleteCar(@PathVariable final String plate) {
    	logger.info("plate:{}",plate);
    	electricCarService.deleteCar(plate);
    }

}
