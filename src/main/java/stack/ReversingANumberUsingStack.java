package stack;

import java.util.Stack;

public class ReversingANumberUsingStack {

	public static void main(String[] args) {
		int x = 12345;
		int result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (x != 0) {
			stack.push(x % 10);
			x = x / 10;
		}
		int i = 1;
		while (!stack.isEmpty()) {
			result = result + stack.pop() * i;
			i = i * 10;
		}
		System.out.println(result);

	}

}
