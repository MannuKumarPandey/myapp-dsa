package linkedlist;

public class DeleteFirstNodewithGivenValue {

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
		head = sortedInsert(199);
		head = sortedInsert(56789);
		head = sortedInsert(5000);
		head = sortedInsert(30);
		traversingOfALinkedList(head);
		System.out.println();
		head = deleteNode(head, 5000);
		traversingOfALinkedList(head);
		System.out.println();
		System.out.println(size);
		System.out.println(searchElement(head, 30));
	}

	private static Node deleteNode(Node head, int givenValue) {

		if (head == null) {
			return null;
		}

		Node temp = head;
		while (temp.next != null) {
			if (temp.next.data == givenValue) {
				temp.next = temp.next.next;
				size--;
				return head;
			}
			temp = temp.next;
		}
		head = head.next;
		temp.next = null;
		size--;
		return head;
	}

	private static boolean searchElement(Node head2, int keyValue) {
		Node temp = head;
		if (temp == null) {
			return false;
		}
		while (temp != null) {
			if (temp.data == keyValue) {
				return true;
			}
			temp = temp.next;
		}

		// TODO Auto-generated method stub
		return false;
	}

	private static void traversingOfALinkedList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	private static Node sortedInsert(int value) {
		Node temp = head;
		Node newNode = new Node(value);

		if (temp == null || temp.data > value) {
			size++;
			newNode.next = head;
			head = newNode;
			return head;

		}
		while (temp.next != null && temp.next.data < value) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		size++;
		return head;

	}

}
