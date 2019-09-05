package com.kurokochu.spring_boot_hello_world;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@RestController
@RequestMapping(value = "hello")
public class SpringBootHelloWorld {

	private static CarFactory factory;

	public static void main(String[] args) {
		factory = new CarFactory();
		factory.init();
		SpringApplication.run(SpringBootHelloWorld.class, args);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "Hello World";
	}

	@RequestMapping(value = "/{firstName}/{lastName}", method = RequestMethod.GET)
	public String hello(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
		return String.format("{\"message\":\"Hello %s %s\"}", firstName, lastName);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String hello(@RequestBody Object object) {
		return String.format("{\"payload\":\"%s\"}", object);
	}

	@RequestMapping(value = "/get")
	public ResponseEntity<ArrayList<Car>> get() {
		return new ResponseEntity<ArrayList<Car>>(factory.getList(), HttpStatus.OK);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Car>> add(@RequestBody ArrayList<Car> cars) {
		for (Car car : cars) {
			factory.addCar(car);
		}
		return new ResponseEntity<ArrayList<Car>>(cars, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Car> update(@RequestBody Car car) {
		factory.updateCar(car);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public ResponseEntity<String> delete(@PathVariable int id) {
		return new ResponseEntity<String>(factory.deleteCar(id) ? "DELETED" : "CAR NOT FOUND", HttpStatus.OK);
	}

}
