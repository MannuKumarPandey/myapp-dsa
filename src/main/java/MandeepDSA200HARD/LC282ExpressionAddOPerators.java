package MandeepDSA200HARD;

import java.util.ArrayList;
import java.util.List;

public class LC282ExpressionAddOPerators {
    public static void main(String[] args) {
        LC282ExpressionAddOPerators solver = new LC282ExpressionAddOPerators();
        String num = "123";
        int target = 6;
        System.out.println(solver.addOperators(num, target)); // Output: ["1+2+3", "1*2*3"]
    }

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(result, "", num, target, 0, 0, 0);
        return result;
    }

        /*
        *
        * path: ban rahi path
        * num: original input
        * target : original target needs to be checked
        * index : current pointer to the string
        * eval: evaluated result of the path
        * prev: previous result
        *
        **/

    private void backtrack(List<String> result, String path, String num, int target, int index, long eval, long prev) {
        // Base case: When we've processed the entire string
        if (index == num.length()) {
            if (eval == target) {
                result.add(path);
            }
            return;
        }

        // Explore each substring starting from the current index
        for (int i = index; i < num.length(); i++) {

            // Skip numbers with leading zeros
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            // Extract the current number
            String currentStr = num.substring(index, i + 1);
            long current = Long.parseLong(currentStr);

            if (index == 0) {
                // First number, we just take it without any operator
                backtrack(result, path + currentStr, num, target, i + 1, current, current);
            } else {
                // Addition
                backtrack(result, path + "+" + currentStr, num, target, i + 1, eval + current, current);

                // Subtraction
                backtrack(result, path + "-" + currentStr, num, target, i + 1, eval - current, -current);

                // Multiplication
                backtrack(result, path + "*" + currentStr, num, target, i + 1, eval - prev + (prev * current), prev * current);
            }
        }
    }
}

