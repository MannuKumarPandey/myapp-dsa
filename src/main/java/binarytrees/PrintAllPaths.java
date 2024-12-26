package binarytrees;

import java.util.Stack;

public class PrintAllPaths {

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
		Stack<Integer> stack = new Stack<Integer>();
		printPaths(head, stack);
	}

	private static void printPaths(Node head, Stack stack) {

		/* Yha ek stack ke madad se ham sare trees ke path pta kar rahe hai */

		if (head == null) {
			return;
		}
		stack.push(head.data);

		if (head.lChild == null && head.rChild == null) {
			System.out.println(stack);
			stack.pop();
			return;
		}

		printPaths(head.lChild, stack);
		printPaths(head.rChild, stack);
		stack.pop();

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
