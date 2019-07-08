package com.shangyang.mycollection;

/**
 * 自定义一个链表
 * 增加add，get方法
 * @author shangyang
 *
 */
public class SyLinkedList<E> {

	private Node first;
	private Node last;
	
	private int size;
	
	public void remove (int index) {
		Node temp = this.getNode(index);
		
		if(temp != null) {
			Node up = temp.previous;
			Node down = temp.next;
			
			if(up != null) {
				up.next = down;
			} 
			if(down != null) {
				down.previous = up;
			}
			if(index == 0) {
				first = down;
			}
			if(index == size-1) {
				last = up;
			}
			size--;
		}
	}
	
	
	public void add(int index,E e) {
		Node newNode = new Node(e);
		Node temp = getNode(index);
		
		if(temp != null) {
			Node up = temp.previous;
			
			up.next = newNode;
			newNode.previous = up;
			
			newNode.next = temp;
			temp.previous = newNode;
		}
		
	}
	
	public E get(int index) {
		if(index<0 || index > size -1) {
			throw new RuntimeException("索引数字不合法" + index);
		}
		Node temp = this.getNode(index);
		return temp!=null?(E)temp.element:null;
	}
	
	public Node getNode(int index) {
		Node temp = null;
		
		if(index<=(size >> 1)) {
			temp = first;
			for(int i = 0; i < index ; i++) {
				temp = temp.next;
			}
		} else {
			temp = last;
			for(int i = size-1; i > index; i--) {
				temp = temp.previous;
			}
		}
		return temp;
	}
	
	public void add(E e) {
		Node node = new Node(e);
		
		if (first == null) {
			
			first = node;
			last = node;
		} else {
			node.previous = last;
			node.next = null;
			last.next = node;
			last = node;
		}
		size++;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		//挨个遍历链表元素
		Node temp = first;
		while(temp!=null) {
			sb.append(temp.element + ",");
			temp = temp.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		SyLinkedList<String> list = new SyLinkedList<String>();
		list.add("aa");
		list.add("bb");
		list.add("c");
		System.out.println(list.toString());
		System.out.println(list.get(0));
		System.out.println(list.get(2));
		list.remove(0);
		System.out.println(list.toString());
		list.add(1, "lalal");
		System.out.println(list);
	}
}
