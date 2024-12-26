package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversingaQueue {

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		System.out.println(queue);
		System.out.println(queue.peek());
		
		Stack<Integer> stack = new Stack<Integer>();
		while(!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		System.out.println(queue);
		
	}

}
