package com.shangyang.lambda;

/**
 * lambda推导
 * @author shangyang
 *
 */
public class LambdaTest01 {

	static class Like2 implements ILike{
		@Override
		public void lambda() {
			// TODO Auto-generated method stub
			System.out.println("i like lambda2");
		}
	}
	
	public static void main(String[] args) {
		ILike like = new Like();
		ILike like2 = new Like2();
		
		
		class Like3 implements ILike{
			@Override
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("i like lambda2");
			}
		}
		
		ILike like3 = new Like3();
		
		ILike like4 = new ILike() {
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("i like lambda3");
			}
		};
		
		//lambda推导必须存在类型
		ILike like5 = ()->{
			System.out.println("i like lambda4");
		};
		like.lambda();
		like2.lambda();
		like3.lambda();
		like4.lambda();
		like5.lambda();
	}
}

interface ILike{
	void lambda();
}

class Like implements ILike{
	@Override
	public void lambda() {
		// TODO Auto-generated method stub
		System.out.println("i like lambda");
	}
}