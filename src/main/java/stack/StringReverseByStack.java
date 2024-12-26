package stack;

import java.util.Stack;

public class StringReverseByStack {
	public static void main(String[] args) {
		StringBuffer  s = new StringBuffer("Mannu");
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i<s.length();i++) {
			stack.push(s.charAt(i));		
		}
		
		
		for(int i=0;i<s.length();i++) {
			s.setCharAt(i,stack.pop());
		}
		System.out.println(s);
	}

}
