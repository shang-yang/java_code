package com.shangyang.linetable;

import java.util.Arrays;

/**
 * 顺序表
 * 底层采用的数组，但是长度可以动态变化
 * 
 * java.util.ArrayList 每次增长50%
 * @author shangyang
 *
 */
public class ArrayList implements List{

	private Object[] elementData;	//底层是一个数组，目前还没有确定长度
	
	private int size;	//不是数组分配了几个空间，而是元素的个数
	
	
	public ArrayList() {
		this(4);
	}
	

	/**
	 * @param initialCapacity 指定数组的初始长度
	 */
	public ArrayList(int initialCapacity) {
		// 给数组分配指定数量的空间
		elementData = new Object[initialCapacity];		
	}
	
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public Object get(int i) {
		
		if( i<0 || i >= size) {
			throw new RuntimeException("数组索引越界异常" + i);
		}
		
		return elementData[i];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean contains(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(int i, Object e) {
		// 数组满了，就扩容
		if (size == elementData.length) {
			grow();
		}
		// 后移i及其后面元素，从最后一个元素开始
		for(int j = size; j > i; j--) {
			elementData[j] = elementData[j-1];
		}
		// 给数组第i个位置赋值
		elementData[i] = e;
		// 元素个数+1
		size++;
	}

	@Override
	public void add(Object e) {
		//数组满了，就扩容
		if(size == elementData.length) {
			grow();
		
		}
		elementData[size] = e;
		// 元素个数加一
		size ++;
	}

	private void grow() {
		// 新创建一个新的数组，长度是旧数组2倍
		Object[] newArr = new Object[elementData.length * 2];
		// 将就数组的数据拷贝到新数组
		for (int i = 0; i < size; i++) {
			newArr[i] = elementData[i];
		}
		// 让elementData指向新数组
		elementData = newArr;
		// elementData = Arrays.copyOf(elementData, elementData.length*2);
	}
	
	@Override
	public boolean addBefore(Object obj, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAfter(Object obj, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object replace(int i, Object e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		if(size == 0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		for(int i=0; i < size; i++) {
			builder.append(elementData[i] + ",");
		}
		builder.setCharAt(builder.length()-1, ']');
		return builder.toString();
	}
}
