package com.shangyang.mycollection;

/**
 * 自定义实现一个ArrayList,体会底层原理
 * 增加泛型
 * 增加数组扩容
 * @author shangyang
 *
 */
public class SxtArrayList02<E> {

	private Object[] elementData;
	private int size;
	private static final int DEFALT_CAPACITY = 10;
	
	public SxtArrayList02() {
		elementData = new Object[DEFALT_CAPACITY];
	}
	
	public SxtArrayList02(int capacity) {
		elementData = new Object[capacity];
	}
	
	public void add(E element) {
		
		//什么时候扩容？？
		if(size == elementData.length) {
			//怎么扩容？？
			Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
			
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		elementData[size++] =element;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for(int i = 0; i < size ; i++) {
				sb.append(elementData[i] + ",");
			}
			sb.setCharAt(sb.length()-1, ']');
			return sb.toString();
		}
	
	public static void main(String[] args) {
		SxtArrayList02<String> s1 = new SxtArrayList02<String>();
		for(int i = 1; i < 40 ; i++) {
			s1.add("" + i);
		}
		
		System.out.println(s1);
	}
}
