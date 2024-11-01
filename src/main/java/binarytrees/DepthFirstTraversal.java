package binarytrees;

import java.util.ArrayDeque;

public class DepthFirstTraversal {

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
		levelOrderTraversal(head);
	}

	private static void levelOrderTraversal(Node head) {
		ArrayDeque<Node> stack = new ArrayDeque<Node>();

		// Array Dequeue can work as stack as well as queue
		// It has both the methods push and add as well

		Node temp;
		if (head != null) {
			stack.push(head);
		}
		while (stack.isEmpty() == false) {
			temp = stack.pop();
			System.out.print(temp.data + " ");

			if (temp.lChild != null) {
				stack.push(temp.lChild);
			}

			if (temp.rChild != null) {
				stack.push(temp.rChild);
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
