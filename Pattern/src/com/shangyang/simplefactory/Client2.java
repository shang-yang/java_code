package com.shangyang.simplefactory;

/**
 * 测试在简单工厂的情况下
 * @author shangyang
 *
 */
public class Client2 {	//调用者

	public static void main(String[] args) {
		Car c1 = CarFactory.createCar("Audi");
		Car c2 = CarFactory.createCar("Byd");
		
		c1.run();
		c2.run();
	}
}
