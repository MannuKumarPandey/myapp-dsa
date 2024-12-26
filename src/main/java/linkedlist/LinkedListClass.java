package linkedlist;

public class LinkedListClass {
	
	ListNode head;

	public LinkedListClass() {
		super();
	}

	
	ListNode addAtFirst(ListNode temp) {
		if(head == null) {
			return head = temp;
		}
		else {
			temp.next = head;
			head = temp;
			return head;
		}
	}
	
	ListNode addAtLast(ListNode temp) {
		if(head == null) {
			return head = temp;
		}
		else {
			ListNode originalTemp = head;
			while(originalTemp.next != null) {
				originalTemp.next = temp;
			}
			return head;
		}
	}
	
	public void print() {
		ListNode temp = head;
		while ( temp!= null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}


