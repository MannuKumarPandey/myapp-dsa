package binarytrees;

public class NthPreOrder {

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
		int index = 2;
		int counter[] = { 0 };
		nthPreOrderTraversal(head, index, counter);
	}

	private static void nthPreOrderTraversal(Node head, int index, int[] counter) {
		if (head == null) {
			return;
		}
		if (head != null) {
			counter[0]++;
		}

		if (counter[0] == index) {
			System.out.print(head.data + " ");

		}

		nthPreOrderTraversal(head.lChild, index, counter);
		nthPreOrderTraversal(head.rChild, index, counter);
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
