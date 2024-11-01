package dynamicprogramming;

import java.util.Arrays;

public class MaxSumOfNonAdjacentElementMemoization {

	
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
		return solveUtil(n - 1, array, dp);
	}

	private static int solveUtil(int index, int[] array, int[] dp) {
		if (index < 0) {
			return 0;
		}

		if (index == 0) {
			return array[index];
		}

		if (dp[index] != -1) {
			return dp[index];
		}

		int pick = array[index] + solveUtil(index - 2, array, dp);
		int nonPick = 0 + solveUtil(index - 1, array, dp);
		return dp[index] = Math.max(pick, nonPick);
	}
}
