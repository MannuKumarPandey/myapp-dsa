package dynamicprogramming;

public class LISTabulation {

	public static void main(String args[]) {

		int arr[] = { 10, 9, 2, 5, 3, 7, 101, 18 };

		int n = arr.length;

		System.out.println("The length of the lis is " + longestIncreasingSubsequence(arr, n));

	}

	static int longestIncreasingSubsequence(int arr[], int n) {

		int dp[][] = new int[n + 1][n + 1];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int prev_index = ind - 1; prev_index >= -1; prev_index--) {

				int notTake = 0 + dp[ind + 1][prev_index + 1];

				int take = 0;

				if (prev_index == -1 || arr[ind] > arr[prev_index]) {

					take = 1 + dp[ind + 1][ind + 1];
				}

				dp[ind][prev_index + 1] = Math.max(notTake, take);

			}
		}

		return dp[0][0];
	}
}
