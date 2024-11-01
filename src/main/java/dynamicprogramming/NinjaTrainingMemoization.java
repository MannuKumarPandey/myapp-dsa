package dynamicprogramming;

import java.util.Arrays;

public class NinjaTrainingMemoization {
	public static void main(String[] args) {
		int points[][] = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };
		int n = points.length;
		System.out.println(ninjaTraining(n, points));
	}

	private static int ninjaTraining(int n, int[][] points) {
		int dp[][] = new int[n][4];
		for (int[] h : dp) {
			Arrays.fill(h, -1);
		}

		return f(n - 1, 3, points, dp);
	}

	private static int f(int day, int last, int[][] points, int[][] dp) {

		if (dp[day][last] != -1) {
			return dp[day][last];
		}

		if (day == 0) {
			int maxi = 0;
			for (int i = 0; i <= 2; i++) {
				if (i != last) {
					maxi = Math.max(maxi, points[0][i]);
				}
			}
			return dp[day][last] = maxi;
		}

		int maxi = 0;
		for (int i = 0; i <= 2; i++) {
			if (i != last) {
				int activity = points[day][i] + f(day - 1, i, points, dp);
				maxi = Math.max(maxi, activity);
			}
		}

		return maxi;
	}
}
