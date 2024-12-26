package dynamicprogramming;

import java.util.Arrays;

import recursion.ReverseAnArray;

public class LongestDivisibleSubSet {

	public static void main(String args[]) {

		int arr[] = { 1, 16, 7, 8, 4 };

		int n = arr.length;

		System.out.println("The length of the lis is " + longestIncreasingSubsequence(arr, n));

	}

	static int longestIncreasingSubsequence(int arr[], int n) {

		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		int hash[] = new int[n];
		Arrays.fill(hash, 1);

		for (int i = 0; i <= n - 1; i++) {
			hash[i] = i; // initializing with current index
			for (int prev_index = 0; prev_index <= i - 1; prev_index++) {

				if (arr[i] % arr[prev_index] == 0 && 1 + dp[prev_index] > dp[i]) {
					dp[i] = 1 + dp[prev_index];
					hash[i] = prev_index;
				}
			}
		}

		return dp[dp.length - 1];

		/*
		 * int ans = -1; int lastIndex =-1;
		 * 
		 * for(int i=0; i<=n-1; i++){ if(dp[i]> ans){ ans = dp[i]; lastIndex = i; } }
		 * 
		 * 
		 * return ans;
		 */
	}

}
