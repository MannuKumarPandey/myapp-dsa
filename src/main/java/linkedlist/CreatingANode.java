package linkedlist;

public class CreatingANode {

	private static class Node {
		private int value ;
		private Node next;
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	private static Node head;
	private static int size;
	
	
	public static void main(String[] args) {
		Node newNode = new Node(100);
		head = newNode;
		size++;
		System.out.println(head.value);
		System.out.println(size);
	}

}
