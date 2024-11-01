package linkedlist;

public class InsertElementAtHead {

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private static Node head;
	private static int size;

	public static void main(String[] args) {
		head = insertAtHead(199);
		head = insertAtHead(5000);
		printNodes(head);
		System.out.println();
		System.out.println(size);
	}

	private static void printNodes(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	private static Node insertAtHead(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			size++;
			return newNode;

		} else {
			newNode.next = head;
			head = newNode;
			size++;
			return head;

		}
	}

}
