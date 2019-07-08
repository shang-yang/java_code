package aaa;

public class bbb {
	public static void main(String[] args) {
		int a = 127;
		Integer b = a;
		Integer c = a;
		Integer d = new Integer(a);
		System.out.println(b==c);
		System.out.println(b==d);

		
	}
}
