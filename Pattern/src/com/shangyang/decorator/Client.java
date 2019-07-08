package com.shangyang.decorator;

public class Client {

	public static void main(String[] args) {
		Car car = new Car();
		
		car.move();
		System.out.println("**********");
		FlyCar flcar = new FlyCar(car);
		flcar.move();
		
		System.out.println("**********");
		WaterCar watercar = new WaterCar(flcar);
		watercar.move();
	}
}
