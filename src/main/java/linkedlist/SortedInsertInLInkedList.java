package linkedlist;

public class SortedInsertInLInkedList {

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
		traversingOfALinkedList(head);
		System.out.println();
		System.out.println(size);
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
