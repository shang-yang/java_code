package com.shangyang.btree;

public class Test {

	public static void main(String[] args) {

		// 创建一个二叉树
		Node nodeF = new Node("F",null,null);
		Node nodeE = new Node("E",null,null);
		Node nodeD = new Node("D",null,null);
		Node nodeC = new Node("C",nodeF,null);
		Node nodeB = new Node("B",nodeD,nodeE);
		Node nodeA = new Node("A",nodeB,nodeC);
		
		// 声明nodeA为根结点
		BinaryTree btree = new LinkedBinaryTree(nodeA);
		
		// 判断二叉树是否为空
		System.out.println(btree.isEmpty());
		
		// 先序递归遍历 A B D E C F
		btree.preOrderTraverse();
		System.out.println();
		
		// 中序递归遍历 D B E A F C
		btree.inOrderTraverse();
		
		// 后序递归遍历
		btree.postOrderTraverse();
		
		// 二叉树的高度
		System.out.println(btree.getHeight());
		
		// 二叉树的结点数量
		System.out.println(btree.size());
		
		// 中序非递归遍历（借助栈）
		btree.inOrderByStack();
		System.out.println();
		// 按照层次遍历（借助队列）
		btree.levelOrderByStack();
		System.out.println();
		// 在二叉树中查找某个值
		System.out.println("查找" + btree.findKey("A"));
	}

}
