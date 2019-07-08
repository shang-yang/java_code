package com.shangyang.myhashmap;

/**
 * 自定义一个HashMap
 * 实现了put方法增加键值对，并解决了键重复问题
 * 实现toString方法
 * 实现get方法，根据key对象获取value
 * @author shangyang
 *
 */
public class SyHashMap {

	Node[] table;	//位桶数组。bucket array
	int size;	//	存放多少个键值对
	
	public SyHashMap() {
		table = new Node[16];	//长度一般定义为2的整数幂
	}
	
	//存放
	public void put(Object key,Object value) {
		Node newNode = new Node();
		newNode.hash = myHash(key.hashCode(),table.length);
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;
		boolean keyRepeat = false;
		Node temp = table[newNode.hash];
		
		Node iterLast = table[newNode.hash];
		
		if(temp == null) {
			//此处数组元素为空，则直接将新节点放进去
			table[newNode.hash] = newNode;
			size++;
		} else {
			//此处数组元素不为空，遍历链表
			while(temp!=null) {
				//判断k如果重复，则覆盖
				if(temp.key.equals(key)) {
					keyRepeat = true;
					temp.value = value;	//	只是覆盖value即可
					break;
				} else {
					//key不重复，
					iterLast = temp;
					temp = temp.next;
				}
			}
			if(!keyRepeat ) {	//如果没有添加重复的健，则添加到链最后
				iterLast.next = newNode;
				size++;
			}
			
		}
	}
	
	//重写toString方法
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		
		for(int i = 0; i < table.length; i++) {
			Node temp = table[i];
			while(temp!=null) {
				sb.append(temp.key + ":" + temp.value + ",");
				temp = temp.next;
			}
		}
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}
	
	
	//get方法
	public Object get(Object key) {
		int hash = myHash(key.hashCode(),table.length);
		Object value = null;
		if(table[hash] != null) {
			Node temp = table[hash];
			while(temp != null) {
				if(temp.key.equals(key)) {
					value = temp.value;
					break;
				} else {
					temp = temp.next;
				}
			}
		}
		return value;
	}
	
	
	//返回哈希值
	public int myHash(int v,int length) {
//		System.out.println("hash in myHash" + (v&(length-1))); //直接位运算，效率高
//		System.out.println("hash in myHash" + (v%(length-1))); //取模运算，效率低
		return v&(length-1);
	}
	
	public static void main(String[] args) {
		SyHashMap map = new SyHashMap();
		map.put(10, "aa");
		map.put(20, "bb");
		map.put(30, "cc");
		map.put(53, "dd");
		map.put(69, "gg");
		System.out.println(map);
		System.out.println(map.get(20));
		System.out.println(map.get(21));
		System.out.println(map.get(53));
	}
}
