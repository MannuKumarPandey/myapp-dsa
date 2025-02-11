package stack;

import java.util.Stack;

public class LC394 {

    public static void main(String[] args) {
       // System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("100[leetcode]"));
    }

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ']') {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    sb.append(stack.peek());
                    stack.pop();
                }
                sb = sb.reverse();
                stack.pop();//removing [
                StringBuilder countS = new StringBuilder();
                int tempp = 0;
                tempp = Integer.parseInt(stack.pop());
                while (!stack.isEmpty() && Character.isDigit(stack.peek()) {

                }
                int count = Integer.parseInt(stack.pop());
                StringBuilder sbt = new StringBuilder();
                while (count-- > 0) {
                    sbt.append(sb);
                }
                stack.push(sbt.toString());

            }
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0,stack.pop());
        }
        return result.toString();
    }
}
