package stack;

import java.util.Stack;

public class ReverseStackByRecursion {
	static Stack<Integer> s = new Stack<Integer>();
	public static void main(String[] args) {
		
		s.add(10);
		s.add(15);
		s.add(20);
		s.add(25);
		s.add(30
				
				);
		System.out.println(s);
		System.out.println(s.peek());
		
		reverse(s);
		System.out.println(s);

	}

	private static void reverse(Stack s) {
		if(!s.isEmpty()) {
			int x = (Integer) s.peek();
			s.pop();
			reverse(s);
			insertAtBottom(x);
		}
	}

	private static void insertAtBottom(int x) {
		if(s.isEmpty()) s.push(x);
		else {
			int y = s.peek();
			s.pop();
			insertAtBottom(x);
			s.push(y);
		}
		
	}

}
