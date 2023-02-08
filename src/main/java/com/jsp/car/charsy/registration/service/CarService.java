package com.jsp.car.charsy.registration.service;

import com.jsp.car.charsy.registration.dao.CarDao;
import com.jsp.car.charsy.registration.dto.Car;
import com.jsp.car.charsy.registration.dto.Charsy;
import com.jsp.car.charsy.registration.dto.Registration;

public class CarService {

	CarDao carDao = new CarDao();

	public Car insertCar(Car car, Charsy charsy, Registration registration) {
		return carDao.insertCar(car, charsy, registration);
	}

	public Car delelteCar(Car car, Charsy charsy, Registration registration) {
		return carDao.deleteCar(car, charsy, registration);
	}

	public Car updateCar(Car car, Charsy charsy, Registration registration) {
		return carDao.updateCar(car, charsy, registration);
	}

	public void getAllDetials() {
		carDao.getAllDetails();
	}

}
