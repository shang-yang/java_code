package com.shangyang.linetable;

public class SingleLinkedList implements List{

	private Node head;	//头结点，不存储数据，为了编程方便
	
	private int size;	// 一共有几个结点
	
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public Object get(int i) {
		// 和顺序表不一样，不能通过索引直接计算定位,而需要从头结点开始进行查找
		Node p = head;
		for(int j = 0; j < i; j++) {
			p = p.next;
		}
		return p.data;
	}

	@Override
	public boolean isEmpty() {
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
		// 如果i位置错误报异常
		if(i < 0 || i > size) {
			throw new RuntimeException("数组指针越界异常：" + i);
		}
		// 找到前一个结点，从head结点开始
		Node p = head;
		for(int j = 0; j < i; j++) {
			p = p.next;
		}
		// 新创建一个结点
		Node newNode = new Node(e);
		// 指明新结点的直接后继结点
		newNode.next = p.next;
		// 指明新结点的直接前驱结点
		p.next = newNode;
		size ++;
	}

	@Override
	public void add(Object e) {
		this.add(size, e);
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
		Node p = head.next;
		for(int i = 0; i < size; i++) {
			builder.append(p.data + ",");
			// 移动指针到下一个结点
			p = p.next;
		}
		builder.setCharAt(builder.length()-1, ']');
		return builder.toString();
	}
}
