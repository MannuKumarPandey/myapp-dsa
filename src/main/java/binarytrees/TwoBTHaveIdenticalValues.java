package binarytrees;

public class TwoBTHaveIdenticalValues {

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
		Node head1 = createCompleteBinaryTree(array, 0);
		Node head2 = head1;
		System.out.println(compreTwoTrees(head1, head2));
	}

	private static boolean compreTwoTrees(Node head1, Node head2) {

		if (head1 == null && head2 == null) {
			return true;
		} else if (head1 == null || head2 == null) {
			return false;
		}
		return compreTwoTrees(head1.lChild, head2.lChild) && compreTwoTrees(head1.rChild, head2.rChild)
				&& head1.data == head2.data;

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
