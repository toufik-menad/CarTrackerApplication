/**
 * 
 */
package com.canada.provisions.services.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import com.canada.provisions.dao.ElectricCarRepository;
import com.canada.provisions.dao.GasCarRepository;
import com.canada.provisions.dto.GasCar;
import com.canada.provisions.entities.ElectricCarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canada.provisions.entities.GasCarEntity;
import com.canada.provisions.services.GasCarService;

/**
 * @author MENAD
 *
 */
@Service
public class GasCarServiceImpl implements GasCarService{

	@Autowired
	private GasCarRepository gasCarRepository;



	@Override
	public GasCar createCar(GasCar car){
			final GasCarEntity gasCarEntity = new GasCarEntity();
			gasCarEntity.setPlate(car.getPlate());
			gasCarEntity.setMake(car.getMake());
			gasCarEntity.setModel(car.getModel());
			gasCarEntity.setYear(car.getYear());
			gasCarEntity.setOdometerReading(car.getOdometerReading());
			gasCarEntity.setGears(car.getGears());
			gasCarRepository.save(gasCarEntity);
			return gasCarRepository.retrieCarAsDTO(car.getPlate());
		}




	@Override
	public void deleteCar(String plate) {

	}

	@Override
	public List<GasCar> getList() {
		return gasCarRepository.findAll().stream().map(car -> gasCarRepository.retrieCarAsDTO(car.getPlate())).collect(Collectors.toList());
	}

	@Override
	public String serviceTires(GasCar car) {
		return null;
	}

	@Override
	public String cleanBody(GasCar car) {
		return null;
	}

	@Override
	public String inspectEngine(GasCar car) {
		return null;
	}




	@Override
	public GasCar getById(String plate) {
		// TODO Auto-generated method stub
		return null;
	}
}