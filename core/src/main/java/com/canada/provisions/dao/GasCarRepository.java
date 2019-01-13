
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
public interface GasCarRepository extends JpaRepository<GasCarEntity, Integer> {

    @Override
    @Query("SELECT c FROM GasCarEntity AS c")
    List<GasCarEntity> findAll();

    @Query("SELECT new com.canada.provisions.dto.GasCar(c.id, c.make, c.model, c.year, c.odometerReading, c.gears) FROM GasCarEntity c WHERE c.id = :id")
    GasCar retrieCarAsDTO(@Param("id") int name);

}
