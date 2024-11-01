package stack;


public class StackUsingLInkedList {
	
	static class Node{
		int data ;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		} 
	}


	static	Node head;
		
	static	Node push(int data) {
			Node newNode = new Node(data);
			if(head!=null) {
				newNode.next = head;
				head = newNode;
			}
			else {
				head = newNode;
			}
			return head;
		}
		
	static	int pop() {
			if(head!=null) {
				int f=  head.data;
				head = head.next;
				return f;
			}
			else {
				return -1;
			}
	}
	static void display() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data +" ");
			System.out.println();
			temp = temp.next;
		}
	}
	static int peek() {
		return head!=null? head.data : -1;
	}
	public static void main(String[] args) {

		StackUsingLInkedList stack = new StackUsingLInkedList();
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.display();
		System.out.println(stack.peek());
		System.out.println("--------------------------");
		stack.pop();
		stack.display();
		
	}
}

