package MandeepDSA200Medium;

import java.util.Arrays;
import java.util.List;

public class LC120Triangle {

    public static void main(String[] args) {
        System.out.println();
    }

    public static int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        // Create a memoization table initialized to a large value
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Start the recursion from the top of the triangle
        return dfs(triangle, 0, 0, memo);
    }

    private static int dfs(List<List<Integer>> triangle, int i, int j, int[][] memo) {
        // Base case: if we reach the last row, return the current value
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        // If already calculated, return the memoized result
        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }

        // Recursive calls for the two possible paths
        int left = dfs(triangle, i + 1, j, memo);
        int right = dfs(triangle, i + 1, j + 1, memo);

        // Store the result in memo and return it
        memo[i][j] = triangle.get(i).get(j) + Math.min(left, right);
        return memo[i][j];
    }
}


