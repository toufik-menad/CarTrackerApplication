/*
 * Copyright (c) 2018, CGI.
 */
package com.canada.provisions.controllers;

import java.util.Optional;

import com.canada.provisions.dao.GasCarRepository;
import com.canada.provisions.entities.DieselCarEntity;
import com.canada.provisions.entities.GasCarEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
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
    GasCarRepository repo;

    @PostMapping()
    public GasCarEntity create(@RequestBody final GasCarEntity gasCarEntity) {
        logger.info("enter create ...");
        repo.save(gasCarEntity);
        return gasCarEntity;
    }

    @PutMapping()
    public GasCarEntity update(@RequestBody final DieselCarEntity gasCarEntity) {
        logger.info("enter update ...");
        final Optional<GasCarEntity> existingCar = repo.findById(gasCarEntity.getId());
        if (existingCar.isPresent()) {
            existingCar.get().setOdometerReading(gasCarEntity.getOdometerReading());
        }
        repo.save(existingCar.get());
        return existingCar.get();
    }

}
