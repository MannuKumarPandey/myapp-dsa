package stack;

import java.util.Stack;

public class ReverseIndividualWordsInString {

	public static void main(String[] args) {

		String s = "My name is Mannu Kumar Pandey";
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(i)==' ') { //till last space of the string but it will execlude the last word of the string
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(" ");
			}
			else {
				stack.push(s.charAt(i));
			}
		}
		while(!stack.isEmpty()) { // Here last word would be present in the stack itself so to get last word 
			//also printed it has to be stack making empty
			System.out.print(stack.pop());
		}
		
		
	}

}
