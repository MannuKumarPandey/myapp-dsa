package dynamicprogramming;

import java.util.Arrays;

public class BuySellStock2Memoization {

	public static void main(String args[]) {
		int n = 6;
		int Arr[] = { 7, 1, 5, 3, 6, 4 };

		System.out.println("The maximum profit that can be generated is " + getMaximumProfit(Arr, n));
	}

	static int getMaximumProfit(int price[], int n) {
		int dp[][] = new int[n][2];
		for (int g[] : dp) {
			Arrays.fill(g, -1);
		}
		return getMaximumProfitUtil(0, 1, price, n, dp);
	}

	static int getMaximumProfitUtil(int index, int buy, int[] price, int n, int[][] dp) {
		if (index == n) {
			return 0;
		}

		if (dp[index][buy] != -1) {
			return dp[index][buy];
		}

		if (buy == 1) {

			return dp[index][buy] = Math.max((-1) * price[index] + getMaximumProfitUtil(index + 1, 0, price, n, dp),
					getMaximumProfitUtil(index + 1, 1, price, n, dp));
		}

		else {
			return dp[index][buy] = Math.max(price[index] + getMaximumProfitUtil(index + 1, 1, price, n, dp),
					getMaximumProfitUtil(index + 1, 0, price, n, dp));
		}

	}

}
