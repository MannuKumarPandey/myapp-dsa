package binarytrees;

public class CopyOneTreeIntoAnother {

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
		Node headCopy = copyOfATree(head);
		postOrderTraversal(headCopy);
	}

	public static void postOrderTraversal(Node head) {
		if (head == null) {
			return;
		}
		postOrderTraversal(head.lChild);
		postOrderTraversal(head.rChild);
		System.out.print(head.data + " ");
	}

	private static Node copyOfATree(Node head) {
		Node temp;
		if (head == null) {
			return null;
		} else {
			temp = new Node(head.data);
			temp.lChild = copyOfATree(head.lChild);
			temp.rChild = copyOfATree(head.rChild);
			return temp;
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
