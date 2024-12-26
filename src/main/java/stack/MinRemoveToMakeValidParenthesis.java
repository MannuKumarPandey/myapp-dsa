package stack;

import java.util.Stack;

public class MinRemoveToMakeValidParenthesis {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    public static String minRemoveToMakeValid(String s) {

        StringBuilder str = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (str.charAt(i) == '(') {
                stack.add(i);
            } else if (str.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    str.setCharAt(i, '*');
                }
            }
        }

        while (!stack.isEmpty()) {
            str.setCharAt(stack.pop(), '*');
        }
        System.out.println(str);
        return str.toString().replaceAll("\\*", "");
    }

}
