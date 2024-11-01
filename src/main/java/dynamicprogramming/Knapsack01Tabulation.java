package dynamicprogramming;

public class Knapsack01Tabulation {

	public static void main(String args[]) {

		int wt[] = { 1, 2, 4, 5 };
		int val[] = { 5, 4, 8, 6 };
		int W = 5;

		int n = wt.length;

		System.out.println("The Maximum value of items, thief can steal is " + knapsack(wt, val, n, W));
	}

	static int knapsack(int[] wt, int[] val, int n, int W) {

		int dp[][] = new int[n][W + 1];

		// Base Condition

		for (int i = wt[0]; i <= W; i++) {
			dp[0][i] = val[0];
		}

		for (int ind = 1; ind < n; ind++) {
			for (int cap = 0; cap <= W; cap++) { // capacity

			// for (int cap = W; cap >= 0; cap--) { // both ways can work here 
				
				int notTaken = 0 + dp[ind - 1][cap];

				int taken = Integer.MIN_VALUE;
				if (wt[ind] <= cap)
					taken = val[ind] + dp[ind - 1][cap - wt[ind]];

				dp[ind][cap] = Math.max(notTaken, taken);
			}
		}

		return dp[n - 1][W];
	}

}
