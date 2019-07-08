package com.shangyang.io;


/**
 * 1.抽象组件：需要装饰的抽象对象（接口或抽象父类）
 * 2.具体组件：需要装饰的对象
 * 3.抽象装饰类：包含了对抽象组件的引用以及装饰着共有的方法
 * 4.具体装饰类：被装饰的对象
 * @author shangyang
 *
 */
public class DecrateTest02 {

	public static void main(String[] args) {
		Drink coffee  = new Coffee();
		Drink suger = new Milk(coffee);	//装饰
		System.out.println(suger.cost() + "-->" + suger.info());
	}
}

//抽象组件
interface Drink{
	double cost();	//费用
	String info();	//说明
}


//具体组件
class Coffee implements Drink {
	private String name = "原味咖啡";
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 10;
	}
	
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return name;
	}
}

//抽象装饰类
class Decorate implements Drink {
	//对抽象组件的引用
	private Drink drink;
	public Decorate(Drink drink) {
		this.drink = drink;
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.drink.cost();
	}
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return this.drink.info();
	}
}


//具体装饰类
class Milk extends Decorate {

	public Milk(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()*4;
	}
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info() + "加入了牛奶";
	}
	
}