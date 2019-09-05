package com.kurokochu.spring_boot_hello_world;

import java.util.ArrayList;

public class CarFactory {

	private ArrayList<Car> cars;
	private int primary_key;

	CarFactory() {

	}

	public void init() {
		cars = new ArrayList<Car>();
		primary_key = -1;
	}

	public ArrayList<Car> getList() {
		return this.cars;
	}

	public void addCar(Car car) {
		car.setId(++primary_key);
		this.cars.add(car);
	}

	public boolean updateCar(Car car) {
		if (car == null) {
			return false;
		}
		for (Car carInStock : cars) {
			if (carInStock.getId() == car.getId()) {
				carInStock.setColor(car.getColor());
				carInStock.setDisplacement(car.getDisplacement());
				carInStock.setSpeed(car.getSpeed());
				carInStock.setType(car.getType());
				return true;
			}
		}
		return false;
	}

	public boolean deleteCar(int carId) {
		if (carId < 0) {
			return false;
		}
		for (Car car : cars) {
			if (car.getId() == car.getId()) {
				cars.remove(car);
				return true;
			}
		}
		return false;

	}

}
