package com.shangyang.btree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree implements BinaryTree {

	private Node root;	// 根结点
	
	public LinkedBinaryTree() {
	}

	public LinkedBinaryTree(Node root) {
		this.root = root;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		System.out.println("二叉树结点数量： ");
		return this.size(root);
	}
	private int size(Node root) {
		if(root == null) {
			return 0;
		} else {
			// 获取左子树的数量
			int nl = this.size(root.leftChild);
			// 获取右子树的数量
			int nr = this.size(root.rightChild);
			// 返回左子树、右子树size之和并加1
			return nl + nr + 1;
		}
	}

	@Override
	public int getHeight() {
		System.out.println("二叉树的高度是 ：");
		return this.getHeight(root);
	}
	private int getHeight(Node root) {
		if(root == null) {
			return 0;
		} else {
			// 获取左子树的高度
			int nl = this.getHeight(root.leftChild);
			// 获取右子树的高度
			int nr = this.getHeight(root.rightChild);
			// 返回左子树、右子树较大高度并加1
			return nl > nr ? nl + 1 : nr + 1;
		}
	}

	@Override
	public Node findKey(Object value) {
		return this.findKey(value,root);
	}
	private Node findKey(Object value,Node root) {
		// 结点为空，可能是整个树的根结点，也可能是递归调用中叶子结点中左孩子和右孩子
		if(root == null) {
			return null;
		} else if (root != null && root.value == value) {
			return root;
		} else {	// 递归体
			Node leftnode = this.findKey(value,root.leftChild);
			Node rightnode = this.findKey(value, root.rightChild);
			if(leftnode != null && leftnode.value == value) {
				return leftnode;
			} else if (rightnode != null && rightnode.value == value) {
				return rightnode;
			} else {
				return null;
			}
		}
	}

	@Override
	public void preOrderTraverse() {
		// 输出根结点的值
		if(root != null) {
			System.out.print(root.value + "  ");
			
			// 对左子树进行先序遍历
			// 构建一个二叉树，根是左子树的根
			BinaryTree leftTree = new LinkedBinaryTree(root.leftChild);
			leftTree.preOrderTraverse();
			
			// 对右子树进行先序遍历
			// 构建一个二叉树，根是左子树的根
			BinaryTree rightTree = new LinkedBinaryTree(root.rightChild);
			rightTree.preOrderTraverse();
		}
	}

	@Override
	public void inOrderTraverse() {
		System.out.println("中序遍历");
		this.inOrderTraverse(root);
		System.out.println();
	}
	private void inOrderTraverse(Node root) {
		if(root != null) {
			// 遍历左子树
			this.inOrderTraverse(root.leftChild);
			// 输出根的值
			System.out.print(root.value + "  ");
			// 遍历右子树
			this.inOrderTraverse(root.rightChild);
		}
	}

	@Override
	public void postOrderTraverse() {
		System.out.println("后序遍历");
		this.postOrderTraverse(root);
		System.out.println();
	}
	private void postOrderTraverse(Node root) {
		if(root != null) {
			// 遍历左子树
			this.postOrderTraverse(root.leftChild);
			// 遍历右子树
			this.postOrderTraverse(root.rightChild);
			// 输出根的值
			System.out.print(root.value + "  ");
		}
	}
	
	@Override
	public void levelOrderByStack() {
		if(root == null) 
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(queue.size() != 0) {
			int len = queue.size();
			for(int i = 0; i < len; i++) {
				Node temp = queue.poll();
				System.out.print(temp.value + "  ");
				if(temp.leftChild != null)
					queue.add(temp.leftChild);
				if(temp.rightChild != null) 
					queue.add(temp.rightChild);
			}
		}
	}

	@Override
	public void inOrderByStack() {
		// 创建栈
		Deque<Node> stack = new LinkedList<Node>();
		Node current = root;
		while(current != null || !stack.isEmpty()) {
			while(current != null) {
				stack.push(current);
				current = current.leftChild;
			}
			
			if(!stack.isEmpty()) {
				current = stack.pop();
				System.out.print(current.value + " ");
				current = current.rightChild;
			}
		}
	}
}
