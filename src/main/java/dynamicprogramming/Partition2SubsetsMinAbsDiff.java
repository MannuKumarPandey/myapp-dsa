package dynamicprogramming;

public class Partition2SubsetsMinAbsDiff {

	public static void main(String args[]) {

		int arr[] = { 1, 2, 3, 7 };
		int n = arr.length;

		System.out.println(
				"Min Absolute Difference in 2 subsets::: " + partitionIntoTwoSubsetSumWithMinAbsoluteDiff(n, arr));

	}

	static int partitionIntoTwoSubsetSumWithMinAbsoluteDiff(int n, int[] arr) {

		int totSum = 0;
		for (int i = 0; i < n; i++) {
			totSum += arr[i];
		}
		int k = totSum;

		boolean dp[][] = new boolean[n][k + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		if (arr[0] <= k)
			dp[0][arr[0]] = true;

		for (int ind = 1; ind < n; ind++) {
			for (int target = 1; target <= k; target++) {

				boolean notTaken = dp[ind - 1][target];

				boolean taken = false;
				if (arr[ind] <= target)
					taken = dp[ind - 1][target - arr[ind]];

				dp[ind][target] = notTaken || taken;
			}
		}

		// dp[n-1][col - > 0 ...... totSum]
		int mini = (int) 1e9;
		for (int s1 = 0; s1 <= totSum / 2; s1++) {
			if (dp[n - 1][s1] == true) {
				mini = Math.min(mini, Math.abs((totSum - s1) - s1));
			}
		}
		return mini;
	}

}
