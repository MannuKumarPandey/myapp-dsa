package binarytrees;

public class IsBTMinHeap {

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
		System.out.println(isMinHeap(head, head.data));
		System.out.println(isMinHeap2(head, head.data, 0, 10));

	}

	// First Approach
	private static boolean isMinHeap(Node head, int parentValue) {
		if (head == null) {
			return true;
		}

		if (head.data < parentValue) {
			return false;
		} else {
			return isMinHeap(head.lChild, head.data) && isMinHeap(head.rChild, head.data);
		}
	}

	// Second Approach with the help of the index
	private static boolean isMinHeap2(Node head, int parentValue, int index, int count) {
		if (head == null) {
			return true;
		}

		if (index > count) {
			return false;
		} else {
			return isMinHeap2(head.lChild, head.data, index * 2 + 1, count)
					&& isMinHeap2(head.rChild, head.data, index * 2 + 2, count);
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
