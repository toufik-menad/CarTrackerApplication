/**
 * 
 */
package com.canada.provisions.services.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canada.provisions.dao.DieselCarRepository;
import com.canada.provisions.dto.DieselCar;
import com.canada.provisions.entities.DieselCarEntity;
import com.canada.provisions.services.DieselCarService;

/**
 * @author MENAD
 *
 */
@Service
public class DieselCarServiceImpl implements DieselCarService{

    @Autowired
    private DieselCarRepository dieselRepository;

    /**
     * @param car
     * @return
     */
    @Override
    public DieselCar createCar(final DieselCar car) {
        final DieselCarEntity dieselCarEntity = new DieselCarEntity();
        dieselCarEntity.setPlate(car.getPlate());
        dieselCarEntity.setMake(car.getMake());
        dieselCarEntity.setModel(car.getModel());
        dieselCarEntity.setYear(car.getYear());
        dieselCarEntity.setOdometerReading(car.getOdometerReading());
        dieselCarEntity.setFuelType(car.getFuelType());
        dieselRepository.save(dieselCarEntity);
        return dieselRepository.retrieCarAsDTO(car.getPlate());

    }

    /**
     * simple method to inform drivers tires need service
     * 
     * @param car
     * @return
     */
    @Override
    public String serviceTires(final DieselCar car) {

        if (car.getOdometerReading() >= dieselRepository.retrieCarAsDTO(car.getPlate()).getOdometerReading()) {

            final Optional<DieselCarEntity> electricCarEntity = dieselRepository.findById(car.getPlate());
            int mileage = 0;

            if (electricCarEntity.isPresent()) {
                mileage = electricCarEntity.get().getOdometerReading();
                electricCarEntity.get().setOdometerReading(car.getOdometerReading());
                dieselRepository.save(electricCarEntity.get());
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
    public String cleanBody(final DieselCar car) {
        final Optional<DieselCarEntity> electricCarEntity = dieselRepository.findById(car.getPlate());

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
    public String inspectEngine(final DieselCar car) {
        final Optional<DieselCarEntity> electricCarEntity = dieselRepository.findById(car.getPlate());

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
    public List<DieselCar> getList() {
        return dieselRepository.findAll().stream().map(car -> dieselRepository.retrieCarAsDTO(car.getPlate())).collect(Collectors.toList());
    }

    /**
     * @param id
     */
    @Override
    public void deleteCar(final String plate) {
        dieselRepository.deleteById(plate);

    }

	@Override
	public String changeOil(final DieselCar car) {
		
		final DieselCar carEntity = dieselRepository.retrieCarAsDTO(car.getPlate());
		
		if(car.getOdometerReading() - carEntity.getOdometerReading() >= 10000) {
			return "time to change oil engine";
		}else {
			return "oil engine in good conditions";
		}
	}

	@Override
	public DieselCar getById(String plate) {
		// TODO Auto-generated method stub
		return null;
	}

}
