package binarytrees;

import java.util.ArrayDeque;

public class IsCompleteBinaryTree {

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
		System.out.println(isCompleteBinaryTree(head));
		System.out.println(isCompleteBinaryTree2(head, 0, 10));
	}

	private static boolean isCompleteBinaryTree(Node head) {
		ArrayDeque<Node> queue = new ArrayDeque<Node>();
		Node temp = null;
		int noOfChild = 0;
		if (head != null) {
			queue.add(head);
		}
		while (queue.isEmpty() == false) {
			temp = queue.remove();

			if (temp.lChild != null) {
				if (noOfChild == 1)
					return false;
				queue.add(temp.lChild);
			} else {
				noOfChild = 1;
			}

			if (temp.rChild != null) {
				if (noOfChild == 1)
					return false;
				queue.add(temp.rChild);
			} else {
				noOfChild = 1;
			}
		}
		return true;
	}

	// Second Approach with the help of the index
	private static boolean isCompleteBinaryTree2(Node head, int index, int count) {
		if (head == null) {
			return true;
		}

		if (index > count) {
			return false;
		} else {
			return isCompleteBinaryTree2(head.lChild, index * 2 + 1, count)
					&& isCompleteBinaryTree2(head.rChild, index * 2 + 2, count);
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
