
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
public interface ElectricCarRepository extends JpaRepository<ElectricCarEntity, Integer> {

    @Override
    @Query("SELECT c FROM ElectricCarEntity AS c")
    List<ElectricCarEntity> findAll();

    @Query("SELECT new com.canada.provisions.dto.ElectricCar(c.id, c.make, c.model, c.year, c.odometerReading, c.autonomy) FROM ElectricCarEntity c WHERE c.id = :id")
    ElectricCar retrieCarAsDTO(@Param("id") int name);

}
