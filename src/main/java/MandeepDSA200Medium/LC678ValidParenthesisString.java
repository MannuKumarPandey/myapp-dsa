package MandeepDSA200Medium;

import java.util.Stack;

public class LC678ValidParenthesisString {

    public static void main(String[] args) {
        System.out.println(checkValidString("(*))"));
    }

    public static boolean checkValidString(String s) {
        int starCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '*') {
                starCount++;
            }
        }
        return starCount == minAddToMakeValid(s);
    }

    public static int minAddToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int len = s.length();
        while (i < len) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                i++;
            } else if(s.charAt(i) == ')'){
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
                i++;
            }else{
                i++;

            }
        }
        return stack.size();
    }
}
