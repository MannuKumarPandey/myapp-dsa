package MandeepDSA200HARD;


import java.util.HashMap;
import java.util.Map;

public class LC10RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println(isMatch("aa","a*"));
    }

    public static boolean isMatch(String s, String p) {
        // Use a map to store memoized results for states (i, j)
        Map<String, Boolean> memo = new HashMap<>();
        return helper(s, p, 0, 0, memo);
    }

    private static boolean helper(String s, String p, int i, int j, Map<String, Boolean> memo) {

        // Check if the result for this state is already computed
        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);


        // Base Case: If both strings are exhausted
        if (j == p.length()) {
            return i == s.length();
        }

        // Check if the first characters match
        boolean firstMatch = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        // Handle '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            // Skip '*' and its preceding element, or use '*' to match
            boolean result = helper(s, p, i, j + 2, memo) || (firstMatch && helper(s, p, i + 1, j, memo));

            memo.put(key, result);
            return result;
        } else {
            // Regular match (no '*')
            boolean result = firstMatch && helper(s, p, i + 1, j + 1, memo);
            memo.put(key, result);
            return result;
        }
    }
}
