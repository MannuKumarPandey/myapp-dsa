package dynamicprogramming;

import java.util.Arrays;

public class MaxSumOfNonAdjacentElementTabulation {

	// This approach is taking
	// TC : O(N) and SC : O(n) + O(n)

	public static void main(String[] args) {
		int array[] = { 2, 1, 4, 9 };
		int n = array.length;
		System.out.println(solve(n, array));
	}

	private static int solve(int n, int[] array) {
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		return solveUtil(n, array, dp);
	}

	private static int solveUtil(int index, int[] array, int[] dp) {
		dp[0] = array[0];

		for (int i = 1; i < index; i++) {
			int pick = array[i];
			if (i > 1) {
				pick += dp[i - 2];
			}
			int nonPick = 0 + dp[i - 1];
			dp[i] = Math.max(pick, nonPick);
		}

		return dp[index - 1];
	}

}
