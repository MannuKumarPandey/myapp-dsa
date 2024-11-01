package binarytrees;

public class NoOfFullNodesinBT {

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

		System.out.println(noOfFullNodes(head));
	}

	private static int noOfFullNodes(Node head) {

		// Wese Nodes jinake children ke pas left and right dono node present ho.

		if (head == null) {
			return 0;
		}

		int count = (noOfFullNodes(head.lChild) + noOfFullNodes(head.rChild));

		if (head.lChild != null && head.rChild != null)
			count++;
		;

		return count;

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
