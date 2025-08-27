package stack;

import java.util.Stack;

public class LC1209RemoveKDuplicateCharacters {

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s, k));  // Expected Output: "aa"
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == c) {
                // Increment count of last character
                stack.peek().count++;

                // If count reaches k, remove this entry
                if (stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                // Push new character with count = 1
                stack.push(new Pair(c, 1));
            }
        }

        // Rebuild result string from stack
        StringBuilder result = new StringBuilder();
        for (Pair p : stack) {
            result.append(String.valueOf(p.ch).repeat(p.count));
        }

        return result.toString();
    }

    // Helper class to hold char + frequency
    static class Pair {
        char ch;
        int count;

        Pair(char c, int count) {
            this.ch = c;
            this.count = count;
        }
    }

}