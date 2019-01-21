
package com.canada.provisions.dao;

import java.util.List;

import com.canada.provisions.dto.GasCar;
import com.canada.provisions.entities.GasCarEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author T.Menad
 */
public interface GasCarRepository extends JpaRepository<GasCarEntity, String> {

    @Override
    @Query("SELECT c FROM GasCarEntity AS c")
    List<GasCarEntity> findAll();

    @Query("SELECT new com.canada.provisions.dto.GasCar(c.plate, c.make, c.model, c.year, c.odometerReading, c.gears) FROM GasCarEntity c WHERE c.plate = :plate")
    GasCar retrieCarAsDTO(@Param("plate") String name);

}
