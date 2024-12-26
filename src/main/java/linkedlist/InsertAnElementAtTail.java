package linkedlist;

public class InsertAnElementAtTail {

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
		head = insertAtTail(199);
		head = insertAtTail(56789);
		head = insertAtTail(5000);
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

	private static Node insertAtTail(int value) {
		Node temp = head;
		Node newNode = new Node(value);
		if (head == null) {
			size++;
			head = newNode;
			return head;

		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			size++;
			return head;

		}
	}

}
