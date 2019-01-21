/**
 * 
 */
package com.canada.provisions.services.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.canada.provisions.entities.GasCarEntity;
import com.canada.provisions.services.GasCarService;

/**
 * @author MENAD
 *
 */
@Service
public class GasCarServiceImpl implements GasCarService{
	
	/**
	 * 
	 * we can customize our implementation here
	 */

	@Override
	public GasCarEntity createCar(GasCarEntity car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCar(String plate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GasCarEntity> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String serviceTires(GasCarEntity car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cleanBody(GasCarEntity car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inspectEngine(GasCarEntity car) {
		// TODO Auto-generated method stub
		return null;
	}

}
