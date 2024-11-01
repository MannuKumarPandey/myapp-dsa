package dynamicprogramming;

import java.util.Arrays;

public class MinPathSumTriangleMemoization {

	public static void main(String[] args) {
		int triangle[][] = { { 1 }, { 2, 3 }, { 3, 6, 7 }, { 8, 9, 6, 10 } };
		int n = triangle.length;
		System.out.println(minimumPathSum(triangle, n));
	}

	private static int minimumPathSum(int[][] triangle, int n) {
		int dp[][] = new int[n][n];
		for (int row[] : dp)
			Arrays.fill(row, -1);
		return minimumPathSumUtil(0, 0, triangle, n, dp);
	}

	private static int minimumPathSumUtil(int i, int j, int[][] triangle, int n, int[][] dp) {

		if (dp[i][j] != -1)
			return dp[i][j];

		if (i == n - 1)
			return triangle[i][j];

		int down = triangle[i][j] + minimumPathSumUtil(i + 1, j, triangle, n, dp);
		int diagonal = triangle[i][j] + minimumPathSumUtil(i + 1, j + 1, triangle, n, dp);

		return dp[i][j] = Math.min(down, diagonal);

	}
}
