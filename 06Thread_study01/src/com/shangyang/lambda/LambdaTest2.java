package com.shangyang.lambda;

/**
 * lambda推导 + 加入参数
 * @author shangyang
 *
 */
public class LambdaTest2 {

	public static void main(String[] args) {
		ILove love = (int a) -> {
			System.out.println("i like lambda-->" + a);
		};
		
		love.lambda(100);
		
		//简化
		love = a -> {
			System.out.println("i like lambda-->" + a);
		};
		love.lambda(1);
		
		//再度简化
		love = a -> System.out.println("i like -->" + a);
		love.lambda(0);
	}
}

interface ILove{
	void lambda(int a);
}

class Love implements ILove{
	@Override
	public void lambda(int a) {
		// TODO Auto-generated method stub
		System.out.println("i like lambda-->" + a);
	}
}