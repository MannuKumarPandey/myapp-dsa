package stack;

import java.util.Stack;

public class LongestValidParenthesis {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
    System.out.println(longestValidParentheses("()(()"));

    }

    public static int longestValidParentheses(String s) {
        int result = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> stackChar = new Stack<Character>();
        Stack<Integer> stackIndex = new Stack<Integer>();


        int len = sb.length();

        int i = 0;
        while (i < len) {
            if (sb.charAt(i) == '(') {
                stackChar.push(sb.charAt(i));
                stackIndex.push(i);

                i++;
            } else if (!stackChar.isEmpty() && sb.charAt(i) == ')' && stackChar.peek() == '(') {
                stackChar.pop();
                stackIndex.pop();
                i++;
            } else {
                sb.setCharAt(i, '*');
                i++;
            }
        }

        while (!stackIndex.isEmpty()) {
            int index = stackIndex.pop();
            sb.setCharAt(index, '*');
        }
        String[] arrSizeCheck = sb.toString().split("\\*");
        for(String gg: arrSizeCheck){
            result = Math.max(result, gg.length());
        }
        return  result == Integer.MIN_VALUE ? 0: result;
    }

}
