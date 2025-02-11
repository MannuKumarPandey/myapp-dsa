package stack;

import java.util.Stack;

public class LC394 {

      public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]")); // Output: "aaabcbc"
        System.out.println(decodeString("100[leetcode]")); // Output: "leetcode" repeated 100 times
    }

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ']') {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                // Step 1: Extract the substring inside [ ]
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    sb.insert(0, stack.pop()); // Insert at beginning instead of reversing later
                }
                stack.pop(); // Remove '['

                // Step 2: Extract the number before '['
                StringBuilder countS = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    countS.insert(0, stack.pop()); // Collect all digits
                }
                int count = Integer.parseInt(countS.toString()); // Convert to int

                // Step 3: Repeat the extracted substring
                StringBuilder repeated = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    repeated.append(sb);
                }

                // Push back the expanded string
                stack.push(repeated.toString());
            }
        }

        // Construct the final result
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
