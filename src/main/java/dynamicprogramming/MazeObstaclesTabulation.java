package dynamicprogramming;

import java.util.Arrays;

public class MazeObstaclesTabulation {

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

		return countWaysUtil(m, n, dp, array);

	}

	private static int countWaysUtil(int m, int n, int dp[][], int array[][]) {

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (array[i][j] == -1) {
					dp[i][j] = 0;
					continue;
				} else if (i == 0 && j == 0) {
					dp[i][j] = 1;
					continue;
				} else {
					int up = 0;
					int left = 0;

					if (i > 0)
						up = dp[i - 1][j];
					if (j > 0)
						left = dp[i][j - 1];

					dp[i][j] = up + left;
				}
			}
		}

		return dp[m - 1][n - 1];
	}

}
