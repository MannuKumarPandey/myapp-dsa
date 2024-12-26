package binarytrees;

import java.util.ArrayDeque;
import java.util.Stack;

import binarytrees.LevelOrderTraversal.Node;

public class BreadthFirstSearchInSpiralOrder {

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
		levelOrderTraversalInSpiralOrder(head);
	}

	private static void levelOrderTraversalInSpiralOrder(Node head) {
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();

		Node temp;
		if (head != null) {
			stack1.push(head);
		}
		while (stack1.size() != 0 || stack2.size() != 0) {
			while (stack1.size() != 0) {
				temp = stack1.pop();
				System.out.print(temp.data + " ");
				if (temp.rChild != null) 
					stack2.push(temp.rChild);
				if (temp.lChild != null) 
					stack2.push(temp.lChild);
				
			}
			while (stack2.size() != 0) {
				temp = stack2.pop();
				System.out.print(temp.data + " ");
				if (temp.lChild != null) 
					stack1.push(temp.lChild);
				if (temp.rChild != null) 
					stack1.push(temp.rChild);
			}

		}
		System.out.println();
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
