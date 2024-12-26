package binarysearchtree;

import java.util.ArrayDeque;

public class InsertAValueInBST {

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
		Node head = createBinaryTree(array, 0, array.length - 1);
		Node head2 = insert(head, 24);
		levelOrderTraversal(head2);
	}

	private static Node insert(Node head, int value) {

		if (head == null) {
			head = new Node(value, null, null);
		} else {
			if (head.data > value) {
				head.lChild = insert(head.lChild, value);
			} else {
				head.rChild = insert(head.rChild, value);
			}
		}

		return head;
	}

	private static void levelOrderTraversal(Node head) {
		ArrayDeque<Node> queue = new ArrayDeque<Node>();
		Node temp;
		if (head != null) {
			queue.add(head);
		}
		while (queue.isEmpty() == false) {
			temp = queue.remove();
			System.out.print(temp.data + " ");

			if (temp.lChild != null) {
				queue.add(temp.lChild);
			}

			if (temp.rChild != null) {
				queue.add(temp.rChild);
			}
		}
	}

	public static Node createBinaryTree(int array[], int start, int end) {

		if (start > end) {
			return null;
		}

		Node curr = null;
		int mid = (start + end) / 2;
		curr = new Node(array[mid]);

		curr.lChild = createBinaryTree(array, start, mid - 1);
		curr.rChild = createBinaryTree(array, mid + 1, end);
		return curr;
	}

}
