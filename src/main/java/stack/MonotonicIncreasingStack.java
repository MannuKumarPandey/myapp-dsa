package stack;

import java.util.Stack;

public class MonotonicIncreasingStack {
	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();

	public void add(int data) {
		if (stack1.isEmpty()) {
			stack1.push(data);
		} else {
			if (stack1.peek() > data) {
				stack2.push(stack1.pop());
			} else {
				stack1.push(data);
			}
		}
	}

	public static void main(String[] args) {

	}
}
