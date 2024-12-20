package dynamicprogramming;

import java.util.Arrays;

public class LISMemoization {

	public static void main(String[] args) {

		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 }; // 2 3 7 101 or 2 3 7 18

		int len = arr.length;
		System.out.println("The length of the lis is " + longestIncreasingSubsequence(arr, len));

	}

	static int longestIncreasingSubsequence(int[] arr, int len) {

		int[][] dp = new int[len][len + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		return getAns(arr, len, 0, -1, dp);
	}

	static int getAns(int[] arr, int len, int currentIndex, int prevIndex, int[][] dp) {

		// base condition
		if (currentIndex == len)
			return 0;

		if (dp[currentIndex][prevIndex + 1] != -1)
			return dp[currentIndex][prevIndex + 1];

		int notTake = 0 + getAns(arr, len, currentIndex + 1, prevIndex, dp);

		int take = 0;

		if (prevIndex == -1 || arr[currentIndex] > arr[prevIndex]) {
			take = 1 + getAns(arr, len, currentIndex + 1, currentIndex, dp);
		}

		return dp[currentIndex][prevIndex + 1] = Math.max(notTake, take);
	}

}
