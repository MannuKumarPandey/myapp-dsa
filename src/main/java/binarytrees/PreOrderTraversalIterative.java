package binarytrees;

import java.util.Stack;

public class PreOrderTraversalIterative {

	public static class Node {
		int data;
		Node lChild;
		Node rChild;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.lChild = left;
			this.rChild = right;
		}

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		int array[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Node head = createCompleteBinaryTree(array, 0);
		preOrderTraversalIterative(head);
	}

	private static void preOrderTraversalIterative(Node head) {
		Stack<Node> stack = new Stack<Node>();
		Node curr;

		if (head != null) {
			stack.add(head);
		}
		while (stack.isEmpty() == false) {
			curr = stack.pop();
			System.out.print(curr.data + " ");

			/*
			 * Yaha concept esa hai ki jab ap rchild ko pahle and fir lchild ko bad me stack
			 * me dalege to nikalate wakt lchild pahle niklega and in order traversal me
			 * pahle root --> left --> right child print hoti hai.
			 */

			if (curr.rChild != null) {
				stack.push(curr.rChild);
			}

			if (curr.lChild != null) {
				stack.push(curr.lChild);
			}

		}
	}

	private static Node createCompleteBinaryTree(int[] array, int index) {
		int size = array.length;
		Node curr = new Node(array[index]);
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		if (left < size) {
			curr.lChild = createCompleteBinaryTree(array, left);
		}
		if (right < size) {
			curr.rChild = createCompleteBinaryTree(array, right);
		}
		return curr;
	}
}
