package dynamicprogramming;

public class BuySellStock2SpaceOptimized {

	public static void main(String args[]) {
		int n = 6;
		long Arr[] = { 7, 1, 5, 3, 6, 4 };

		System.out.println("The maximum profit that can be generated is " + getMaximumProfit(Arr, n));
	}

	static long getMaximumProfit(long Arr[], int n) {
		// Write your code here

		long ahead[] = new long[2];
		long cur[] = new long[2];

		// base condition
		ahead[0] = ahead[1] = 0;

		long profit = 0;

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 0) {// We can buy the stock
					profit = Math.max(0 + ahead[0], -Arr[ind] + ahead[1]);
				}

				if (buy == 1) {// We can sell the stock
					profit = Math.max(0 + ahead[1], Arr[ind] + ahead[0]);
				}
				cur[buy] = profit;
			}

			ahead = (long[]) (cur.clone());
		}
		return cur[0];
	}
}
