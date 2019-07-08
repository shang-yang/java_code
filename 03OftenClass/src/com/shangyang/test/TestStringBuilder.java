package com.shangyang.test;

public class TestStringBuilder {
	public static void main(String[] args) {
		
		//StringBuilder线程不安全，效率高（一般用它）；StringBuffer线程安全，效率低
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 26; i++) {
			char temp = (char)('a'+i);
			sb.append(temp);
		}
		
		System.out.println(sb);
		sb.reverse();	//倒序
		System.out.println(sb);
		
		sb.setCharAt(3, '李');
		System.out.println(sb);
		
		sb.insert(0,'我').insert(2, '爱').insert(4,'你');
		System.out.println(sb);
		
		sb.delete(20, 22);
		System.out.println(sb);

	}
}
