package binarytrees;

public class ConvertTreeToDoublyLinkedList {

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
		Node head1 = treeToList(head);

	}

	private static Node treeToList(Node curr) {
		Node head = null;
		Node tail = null;
		if (curr == null) {
			return null;
		}
		if (curr.lChild == null && curr.rChild == null) {
			curr.lChild = curr;
			curr.rChild = curr;
			return curr;
		}
		if (curr.lChild != null) {
			head = treeToList(curr.lChild);
			tail = head.lChild;
			curr.lChild = tail;
			tail.rChild = curr;
		} else {
			head = curr;
		}
		if (curr.rChild != null) {
			Node tempHead = treeToList(curr.rChild);
			tail = tempHead.lChild;
			curr.rChild = tempHead;
			tempHead.lChild = curr;
		} else {
			tail = curr;
		}

		head.lChild = tail;
		tail.rChild = head;
		return head;

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
