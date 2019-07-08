package com.shangyang.lambda;

/**
 * lambda推导 + 参数 + 返回值
 * @author shangyang
 *
 */
public class LambdaTest3 {

	public static void main(String[] args) {
		IInterest interest = (int a,int b)->{
			System.out.println("i like lambda-->" + (a + b));
			return a+b;
		};
		interest.lambda(100, 200);
		
		interest = (a,b)->{
			System.out.println("i like lambda-->" + (a + b));
			return a+b;
		};
		interest.lambda(1010, 2020);
		
		interest = (a,b) -> a+b;
		System.out.println(interest.lambda(2, 3));
	}
}

interface IInterest{
	int lambda(int a,int b);
}

class Interest implements IInterest{
	@Override
	public int lambda(int a,int b) {
		// TODO Auto-generated method stub
		System.out.println("i like lambda-->" + (a + b));
		return a+b;
	}
}