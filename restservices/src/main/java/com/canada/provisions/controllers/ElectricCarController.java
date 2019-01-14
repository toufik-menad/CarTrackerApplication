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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MENAD
 */
@RestController
@RequestMapping("electriccar")
public class ElectricCarController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ElectricCarService electricCarService;

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
