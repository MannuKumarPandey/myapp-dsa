package MandeepDSA200HARD;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC1106BooleanExpression {


    public static void main(String[] args) {
        System.out.println(parseBoolExpr("&(|(f))"));
        System.out.println(parseBoolExpr("|(f,f,f,t)"));
        System.out.println(parseBoolExpr("!(&(f,t))"));
    }
    public static boolean parseBoolExpr(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ')') {
                stack.push(s.charAt(i));
            } else {
                char tempR = 'f';
                List<Character> list = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    list.add(stack.pop());
                }
                stack.pop();//pop (
                if (!stack.isEmpty()) {
                    char operator = stack.pop();
                    if (operator == '|') {
                        tempR = performOr(list);
                    } else if (operator == '&') {
                        tempR = performAnd(list);
                    } else if (operator == '!') {
                        tempR = list.get(0) == 'f' ? 't' : 'f';
                    }
                }
                stack.push(tempR);
            }
        }
        return stack.peek() == 't' ;
    }

    public static char performOr(List<Character> list) {
        if (list.contains('t')) {
            return 't';
        } else return 'f';
    }

    public static char performAnd(List<Character> list) {
        if (list.contains('f')) {
            return 'f';
        } else return 't';
    }

}
