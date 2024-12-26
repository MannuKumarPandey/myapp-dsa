package dynamicprogramming;

import java.util.Arrays;

public class MazeObstacleMemoization {

	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		int array[][] = { { 0, 0, 0 }, { 0, -1, 0 }, { 0, 0, 0 } };
		System.out.println(countWays(m, n, array));
	}

	private static int countWays(int m, int n, int array[][]) {
		int dp[][] = new int[m][n];

		for (int g[] : dp) {
			Arrays.fill(g, -1);
		}

		return countWaysUtil(m - 1, n - 1, dp, array);

	}

	private static int countWaysUtil(int i, int j, int dp[][], int array[][]) {
		if (i == 0 && j == 0) {
			return 1;
		}

		if (i < 0 || j < 0) {
			return 0;
		}
		if (i >= 0 && j >= 0 && array[i][j] == -1) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int up = countWaysUtil(i - 1, j, dp, array);
		int left = countWaysUtil(i, j - 1, dp, array);
		return dp[i][j] = up + left;
	}
}
