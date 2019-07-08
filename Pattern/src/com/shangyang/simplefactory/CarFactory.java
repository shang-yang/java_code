package com.shangyang.simplefactory;

public class CarFactory {

	public static Car createCar(String type) {
		if("Audi".equals(type)) {
			return new Audi();
		} else if ("Byd".equals(type)) {
			return new Byd();
		} else {
			return null;
		}
	}
	
	
	//另一种方法
	/**
	public static Car createCar(String type) {
		Car c = null
		if("Audi".equals(type)) {
			c =  new Audi();
		} else if ("Byd".equals(type)) {
			c =  new Byd();
		}
		return c;
	}
	 */
	
	
	
	
	
}
