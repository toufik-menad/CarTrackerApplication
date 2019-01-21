
package com.canada.provisions.services.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.canada.provisions.dao.ElectricCarRepository;
import com.canada.provisions.dto.ElectricCar;
import com.canada.provisions.entities.ElectricCarEntity;
import com.canada.provisions.services.ElectricCarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author T.Menad
 */
@Service
public class ElectricCarServiceImpl implements ElectricCarService {

    @Autowired
    private ElectricCarRepository electricRepository;

    /**
     * @param car
     * @return
     */
    @Override
    public ElectricCar createCar(final ElectricCar car) {
        final ElectricCarEntity electricCarEntity = new ElectricCarEntity();
        electricCarEntity.setPlate(car.getPlate());
        electricCarEntity.setMake(car.getMake());
        electricCarEntity.setModel(car.getModel());
        electricCarEntity.setYear(car.getYear());
        electricCarEntity.setOdometerReading(car.getOdometerReading());
        electricCarEntity.setAutonomy(car.getAutonomy());
        electricRepository.save(electricCarEntity);
        return electricRepository.retrieCarAsDTO(car.getPlate());

    }

    /**
     * simple method to inform drivers tires need service
     * 
     * @param car
     * @return
     */
    @Override
    public String serviceTires(final ElectricCar car) {

        if (car.getOdometerReading() >= electricRepository.retrieCarAsDTO(car.getPlate()).getOdometerReading()) {

            final Optional<ElectricCarEntity> electricCarEntity = electricRepository.findById(car.getPlate());
            int mileage = 0;

            if (electricCarEntity.isPresent()) {
                mileage = electricCarEntity.get().getOdometerReading();
                electricCarEntity.get().setOdometerReading(car.getOdometerReading());
                electricRepository.save(electricCarEntity.get());
            }

            if (car.getOdometerReading() - mileage >= Constants.TIRESERVICE.getValue()) {

                return "change tires";
            } else {
                return "tires are ok";
            }
        } else {
            return "invalid odometer reading";
        }
    }

    /**
     * @param car
     * @return
     */
    @Override
    public String cleanBody(final ElectricCar car) {
        final Optional<ElectricCarEntity> electricCarEntity = electricRepository.findById(car.getPlate());

        if (electricCarEntity.isPresent() && (car.getOdometerReading() - electricCarEntity.get()
                .getOdometerReading() >= Constants.CLEANINGSERVICE.getValue())) {

            return "charge your vehicle";

        } else {
            return "vehicle is still clean";
        }
    }

    /**
     * @param car
     * @return
     */
    @Override
    public String inspectEngine(final ElectricCar car) {
        final Optional<ElectricCarEntity> electricCarEntity = electricRepository.findById(car.getPlate());

        if (electricCarEntity.isPresent() && (car.getOdometerReading() - electricCarEntity.get().getOdometerReading() >= Constants.INSPECTENGINE
                .getValue())) {

            return "inspect engine";

        } else {
            return "engine is still ok";
        }
    }

    /**
     * @return
     */
    @Override
    public List<ElectricCar> getList() {
        return electricRepository.findAll().stream().map(car -> electricRepository.retrieCarAsDTO(car.getPlate())).collect(Collectors.toList());
    }

    /**
     * @param id
     */
    @Override
    public void deleteCar(final String plate) {
        electricRepository.deleteById(plate);

    }

    /**
     * @return
     */
    @Override
    public String chargeBatteries(final ElectricCar car) {
        final Optional<ElectricCarEntity> electricCarEntity = electricRepository.findById(car.getPlate());

        if (electricCarEntity.isPresent() && (car.getOdometerReading() - electricCarEntity.get().getOdometerReading() >= Constants.BATTERYCHARGE
                .getValue())) {

            return "charge your battery";

        } else {
            return "battery is ok";
        }

    }

}
