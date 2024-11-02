package stack;

import java.util.Stack;

public class CountCollisions {
    public static void main(String[] args) {
        System.out.println(countCollisions("RLRSLL"));
    }


    public static int countCollisions(String d) {
        int c = 0;
        Stack<Character> s = new Stack<>();
        s.push(d.charAt(0));
        for (int i = 1; i < d.length(); i++) {
            char curr = d.charAt(i);
            if (s.peek() == 'R' && curr == 'L') {
                c += 2;
                s.pop();
                curr = 'S';
            } else if (s.peek() == 'S' && curr == 'L') {
                c += 1;
                curr = 'S';
            }
            while (!s.isEmpty() && (s.peek() == 'R' && curr == 'S')) {
                c += 1;
                s.pop();
            }
            s.push(curr);
        }
        return c;
    }

}
