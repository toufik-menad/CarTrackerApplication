/*
 * Copyright (c) 2018, CGI.
 */
package com.canada.provisions.controllers;

import java.util.Optional;

import com.canada.provisions.dao.DieselCarRepository;
import com.canada.provisions.entities.DieselCarEntity;

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
@RequestMapping("dieselcar")
public class DieselCarController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DieselCarRepository repo;

    @PostMapping()
    public DieselCarEntity create(@RequestBody final DieselCarEntity dieselCarEntity) {
        logger.info("enter create ...");
        repo.save(dieselCarEntity);
        return dieselCarEntity;
    }

    @PutMapping()
    public DieselCarEntity update(@RequestBody final DieselCarEntity dieselCarEntity) {
        logger.info("enter update ...");
        final Optional<DieselCarEntity> existingCar = repo.findById(dieselCarEntity.getId());
        if (existingCar.isPresent()) {
            existingCar.get().setOdometerReading(dieselCarEntity.getOdometerReading());
        }
        repo.save(existingCar.get());
        return existingCar.get();
    }

}
