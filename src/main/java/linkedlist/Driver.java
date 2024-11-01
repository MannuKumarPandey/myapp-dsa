package linkedlist;

public class Driver {

	public static void main(String[] args) {

		LinkedListClass ll = new LinkedListClass();
		ll.addAtFirst(new ListNode(100,null));
		ll.print();
		ll.addAtLast(new ListNode(10, null));
		ll.print();
	}

}
