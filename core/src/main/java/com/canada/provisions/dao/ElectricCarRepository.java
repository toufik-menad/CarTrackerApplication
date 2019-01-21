
package com.canada.provisions.dao;

import java.util.List;

import com.canada.provisions.dto.ElectricCar;
import com.canada.provisions.entities.ElectricCarEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author MENAD
 */
@Repository
public interface ElectricCarRepository extends JpaRepository<ElectricCarEntity, String> {

    @Override
    @Query("SELECT c FROM ElectricCarEntity AS c")
    List<ElectricCarEntity> findAll();

    @Query("SELECT new com.canada.provisions.dto.ElectricCar(c.plate, c.make, c.model, c.year, c.odometerReading, c.autonomy) FROM ElectricCarEntity c WHERE c.plate = :plate")
    ElectricCar retrieCarAsDTO(@Param("plate") String name);

}
