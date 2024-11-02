package string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseParenthesis {


    public static void main(String[] args) {
        System.out.println(reverseParentheses("(u(love)i)"));
    }

    public static String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ')') {
                stack.push(s.charAt(i));
            } else {
                Queue<Character> queue = new LinkedList<Character>();
                while (stack.peek() != '(') {
                    queue.add(stack.pop());
                }
                stack.pop();

                while (!queue.isEmpty()) {
                    stack.push(queue.remove());
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}

