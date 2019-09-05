package com.kurokochu.spring_boot_hello_world;

public class Car {

	private int id;
	private String color;
	private double speed;
	private boolean sunroof;
	private int displacement;
	private String type;

	Car() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getSpeed() {
		return this.speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public boolean getSunroof() {
		return this.sunroof;
	}

	public void setSunroof(boolean sunroof) {
		this.sunroof = sunroof;
	}

	public int getDisplacement() {
		return this.displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
