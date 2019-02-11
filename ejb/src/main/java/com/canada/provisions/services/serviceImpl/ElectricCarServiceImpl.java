
package com.canada.provisions.services.serviceImpl;

import java.time.Year;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;
import javax.smartcardio.CardNotPresentException;

import com.canada.provisions.dao.ElectricCarRepository;
import com.canada.provisions.dto.ElectricCar;
import com.canada.provisions.entities.ElectricCarEntity;
import com.canada.provisions.exceptions.NoCarFoundException;
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
     * {@inheritDoc}
     *
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
     * {@inheritDoc}
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
     * {@inheritDoc}
     *
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
     * {@inheritDoc}
     *
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
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public List<ElectricCar> getList() {
        return electricRepository.findAll().stream().map(car -> electricRepository.retrieCarAsDTO(car.getPlate())).collect(Collectors.toList());
    }

    /**deletes a car instance based on the plate number
     * {@inheritDoc}
     *
     * @param plate
     */
    @Override
    public void deleteCar(final String plate) throws CardNotPresentException {
            final Optional<ElectricCarEntity> car = electricRepository.findById(plate);
            if (car.isPresent()) {
                electricRepository.deleteById(plate);
            } else {
                throw new CardNotPresentException("Instance Does not Exidst");
            }
    }

    /**
     * {@inheritDoc}
     *
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

    /**
     * {@inheritDoc}
     */
    @Override
    public ElectricCar getById(String plate) throws NoCarFoundException {
        try {
            final Optional<ElectricCarEntity> entity = electricRepository.findById(plate);
            final ElectricCar carDTO = new ElectricCar(entity.get().getPlate(), entity.get().getMake(), entity.get().getModel(), entity.get().getYear(), entity.get().getOdometerReading(), entity.get().getAutonomy());
            return carDTO;
        } catch (final NoSuchElementException ex) {
            throw new NoCarFoundException(ex.getMessage());
        }

    }

}
