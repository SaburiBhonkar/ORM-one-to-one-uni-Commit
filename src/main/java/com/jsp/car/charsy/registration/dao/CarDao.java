package com.jsp.car.charsy.registration.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.car.charsy.registration.dto.Car;
import com.jsp.car.charsy.registration.dto.Charsy;
import com.jsp.car.charsy.registration.dto.Registration;

public class CarDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("saburi");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Car insertCar(Car car, Charsy charsy, Registration registration) {
		entityTransaction.begin();
		entityManager.persist(car);
		entityManager.persist(charsy);
		entityManager.persist(registration);
		entityTransaction.commit();
		System.out.println("Record Added");
		return car;
	}

	public Car deleteCar(Car car, Charsy charsy, Registration registration) {
		Car car2 = entityManager.find(Car.class, car.getId());
		Charsy charsy2 = entityManager.find(Charsy.class, charsy.getId());
		Registration registration2 = entityManager.find(Registration.class, registration.getId());

		entityTransaction.begin();
		entityManager.remove(car2);
		entityManager.remove(charsy2);
		entityManager.remove(registration2);
		entityTransaction.commit();
		System.out.println("Record Deleted");
		return car2;
	}

	public Car updateCar(Car car, Charsy charsy, Registration registration) {
		Car car2 = entityManager.find(Car.class, car.getId());
		Charsy charsy2 = entityManager.find(Charsy.class, charsy.getId());
		Registration registration2 = entityManager.find(Registration.class, registration.getId());

		if (car2 != null) {
			car2.setName(car.getName());
			car2.setBrand(car.getBrand());
			System.out.println("Record Updated");
		} else
			System.out.println("Record Not Found");

		entityTransaction.begin();
		entityManager.merge(car2);
		entityTransaction.commit();

		return car2;
	}

	public void getAllDetails() {
		String sql1 = "select car from Car car";
		String sql2 = "select charsy from Charsy charsy";
		String sql3 = "select registration from Registration registration";
		Query query1 = entityManager.createQuery(sql1);
		Query query2 = entityManager.createQuery(sql2);
		Query query3 = entityManager.createQuery(sql3);

		List<Car> cars = query1.getResultList();
		List<Charsy> charsies = query2.getResultList();
		List<Registration> registrations = query3.getResultList();

		for (Registration r : registrations) {
			System.out.println(r.getId());
			System.out.println(r.getNumber());
		}
		for (Car car : cars) {
			System.out.println(car.getId());
			System.out.println(car.getName());
			System.out.println(car.getBrand());
		}
		for (Charsy c : charsies) {
			System.out.println(c.getId());
			System.out.println(c.getNumber());
		}
	}
	
}
