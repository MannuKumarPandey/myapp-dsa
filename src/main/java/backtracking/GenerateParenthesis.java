package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3).toString());
    }

    public static List<String> generateParenthesis(int n) {
        List<String> response = new ArrayList<>();
        backtrack(response, new StringBuilder(), n, 0, 0);
        return response;
    }

    private static void backtrack(List<String> list, StringBuilder sb, int n, int open, int close) {
        if (sb.length() == n * 2) {
            list.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backtrack(list, sb, n, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(list, sb, n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}

