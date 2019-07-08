package com.shangyang.decorator;

/**
 * 抽象组件
 * @author shangyang
 *
 */
public interface ICar {

	public void move();
}

/**
 * 具体构建角色（真实角色）
 * @author shangyang
 *
 */
class Car implements ICar {
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("陆地跑");
	}
}


/**
 * 装饰角色
 * @author shangyang
 *
 */
class SuperCar implements ICar {
	
	protected ICar car;
	
	public SuperCar(ICar car) {
		super();
		this.car = car;
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		car.move();
	}
}

/**
 * 具体装饰对象
 * @author shangyang
 *
 */
class FlyCar extends SuperCar {

	public FlyCar(ICar car) {
		super(car);
		// TODO Auto-generated constructor stub
	}
	
	public void fly() {
		System.out.println("天上飞");
	}
	
	public void move() {
		super.move();
		fly();
	}
}


class WaterCar extends SuperCar {

	public WaterCar(ICar car) {
		super(car);
		// TODO Auto-generated constructor stub
	}
	
	public void swim() {
		System.out.println("水里游");
	}
	
	public void move() {
		super.move();
		swim();
	}
}
