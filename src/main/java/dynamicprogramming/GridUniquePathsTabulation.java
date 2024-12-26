package dynamicprogramming;

import java.util.Arrays;

public class GridUniquePathsTabulation {

	public static void main(String[] args) {
		int m = 3;
		int n = 2;
		System.out.println(countWays(m, n));
	}

	private static int countWays(int m, int n) {
		int dp[][] = new int[m][n];

		for (int g[] : dp) {
			Arrays.fill(g, -1);
		}

		return countWaysUtil(m, n, dp);

	}

	private static int countWaysUtil(int m, int n, int dp[][]) {

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (i == 0 && j == 0) {
					dp[i][j] = 1;
					continue;
				}

				int up = 0;
				int left = 0;

				if (i > 0)
					up = dp[i - 1][j];
				if (j > 0)
					left = dp[i][j - 1];

				dp[i][j] = up + left;
			}
		}
		return dp[m - 1][n - 1];
	}
}
