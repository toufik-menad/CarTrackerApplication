
package com.canada.provisions.dao;

import java.util.List;

import com.canada.provisions.dto.DieselCar;
import com.canada.provisions.entities.DieselCarEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author T.Menad
 */
@Repository
public interface DieselCarRepository extends JpaRepository<DieselCarEntity, Integer> {

    @Override
    @Query("SELECT c FROM DieselCarEntity AS c")
    List<DieselCarEntity> findAll();

    @Query("SELECT new com.canada.provisions.dto.DieselCar(c.id, c.make, c.model, c.year, c.odometerReading, c.fuelType) FROM DieselCarEntity c WHERE c.id = :id")
    DieselCar retrieCarAsDTO(@Param("id") int name);

}
