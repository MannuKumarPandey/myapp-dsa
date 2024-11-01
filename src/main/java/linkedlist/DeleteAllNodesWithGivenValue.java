package linkedlist;

public class DeleteAllNodesWithGivenValue {

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
		head = insertAtTail(5000);
		traversingOfALinkedList(head);
		System.out.println();
		head = deleteAllNodes(head, 5000);
		traversingOfALinkedList(head);
		System.out.println();
		System.out.println(size);
		System.out.println(searchElement(head, 30));
	}

	private static Node deleteAllNodes(Node head, int givenValue) {
		Node temp = head;
		Node nextNode = null;

		if (head == null) {
			return null;
		}
		while (temp != null && temp.data == givenValue) {// isase sare wo elements jo givenvalue ke barabar hai and
			// first position par aa rahe ho har bar ke deletion ke bad bhi
			head = temp.next;
			temp = head;
			size--;

		}

		while (temp != null) {
			nextNode = temp.next;
			if (nextNode != null && nextNode.data == givenValue) {
				temp.next = nextNode.next;
				size--;

			} else {
				temp = nextNode;
			}

		}
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
