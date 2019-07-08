package com.shangyang.flyweight;

public class Client {

	public static void main(String[] args) {
		ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("block");
		ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("block");
		
		System.out.println(chess1);
		System.out.println(chess2);
		
		
		System.out.println("增加外部状态的处理======");
		chess1.display(new Coordinate(10,10));
		chess2.display(new Coordinate(14,14));
	}
}
