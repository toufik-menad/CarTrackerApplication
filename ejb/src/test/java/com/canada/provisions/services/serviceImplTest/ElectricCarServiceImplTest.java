/**
 * 
 */
package com.canada.provisions.services.serviceImplTest;
import  org.junit.Assert;
import static org.junit.Assert.assertEquals;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.canada.provisions.dao.ElectricCarRepository;
import com.canada.provisions.dto.ElectricCar;
import com.canada.provisions.services.ElectricCarService;

/**
 * @author MENAD
 *
 */
@ContextConfiguration(classes = {ApplicationContext.class})
public class ElectricCarServiceImplTest {
	
	@Autowired
	 private ElectricCarRepository electricRepository;
	
	@Autowired
	 private ElectricCarService electricCarService;
	
	@Test
	public void createCarTest() {
		ElectricCar car = new ElectricCar();
		car.setPlate("plate");;
		electricRepository = PowerMockito.mock(ElectricCarRepository.class);
		PowerMockito.doReturn(new ElectricCar()).when(electricRepository).retrieCarAsDTO(Mockito.any());
		ElectricCar createdCar = electricCarService.createCar(car);
		assertEquals(createdCar,car);
		
	}

}
