package com.shangyang.mycollection;

/**
 * 自定义实现一个ArrayList,体会底层原理
 * 增加泛型
 * 增加数组扩容
 * 增加set和get方法、增加数组边界检查
 * 增加删除元素
 * @author shangyang
 *
 */
public class SxtArrayList03<E> {

	private Object[] elementData;
	private int size;
	private static final int DEFALT_CAPACITY = 10;
	
	public SxtArrayList03() {
		elementData = new Object[DEFALT_CAPACITY];
	}
	
	public SxtArrayList03(int capacity) {
		if(capacity < 0) {
			throw new RuntimeException("容器的容量不能为负数");
		} else if(capacity == 0) {
			elementData = new Object[DEFALT_CAPACITY];
		} else {
			elementData = new Object[capacity];
		}
		
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
	
	public E get(int index) {
		this.checkRange(index);
		return (E)elementData[index];
	}
	
	public void set(E element,int index) {
		this.checkRange(index);
		elementData[index] = element;
	}
	
	public void checkRange(int index) {
		//索引合法判断[0,size)
		if(index < 0 || index > size-1) {
			throw new RuntimeException("索引不合法" + index);
		}
	}
	
	public void remove(E element) {
		//element，将它和所有元素一次比较，获得第一个比较为true的，返回
		for(int i = 0; i < size; i++) {
			if(element.equals(get(i))) {
				//将该元素从此处移除
				remove(i);
			}
		}
	}
	
	public void remove(int index ) {
		System.arraycopy(elementData, index+1, elementData, index, elementData.length - index - 1);
		elementData[size-1] = null;
		size--;
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
		SxtArrayList03<String> s1 = new SxtArrayList03<String>();
		for(int i = 1; i < 40 ; i++) {
			s1.add("" + i);
		}
		s1.remove("5");
		System.out.println(s1);
	}
}
