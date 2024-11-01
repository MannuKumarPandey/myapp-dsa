package dynamicprogramming;

import java.util.Arrays;

public class BuySellStock3Memoization {

	public static void main(String args[]) {
		int n = 6;
		int Arr[] = { 7, 1, 5, 3, 6, 44 };

		System.out.println("The maximum profit that can be generated is " + getMaximumProfit(Arr, n));
	}

	static int getMaximumProfit(int price[], int n) {
		int cap = 2;
		int dp[][][] = new int[n][2][3];
		for (int g[][] : dp) {
			for (int h[] : g) {
				Arrays.fill(h, -1);
			}

		}
		return getMaximumProfitUtil(0, 1, price, n, dp, cap);
	}

	static int getMaximumProfitUtil(int index, int buy, int[] price, int n, int[][][] dp, int cap) {
		if (index == n || cap == 0) {
			return 0;
		}

		if (dp[index][buy][cap] != -1) {
			return dp[index][buy][cap];
		}

		if (buy == 1) {

			return dp[index][buy][cap] = Math.max(
					(-1) * price[index] + getMaximumProfitUtil(index + 1, 0, price, n, dp, cap),
					getMaximumProfitUtil(index + 1, 1, price, n, dp, cap));
		}

		else {
			return dp[index][buy][cap] = Math.max(
					price[index] + getMaximumProfitUtil(index + 1, 1, price, n, dp, cap - 1),
					getMaximumProfitUtil(index + 1, 0, price, n, dp, cap));
		}

	}

}
