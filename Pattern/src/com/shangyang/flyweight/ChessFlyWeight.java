package com.shangyang.flyweight;

/**
 * 享元类
 * @author shangyang
 *
 */
public interface ChessFlyWeight {

	public void setColor(String c);
	public String getColor();
	public void display(Coordinate c);
}


class ConcreteChess implements ChessFlyWeight {

	private String color;

	public ConcreteChess(String color) {
		super();
		this.color = color;
	}

	@Override
	public void setColor(String c){
		this.color = c;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void display(Coordinate c) {
		System.out.println("棋子颜色：" + color);
		System.out.println("棋子位置：" + c.getX() + "    " + c.getY());
	}
	
}