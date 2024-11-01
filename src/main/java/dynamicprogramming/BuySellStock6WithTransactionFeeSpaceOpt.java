package dynamicprogramming;

public class BuySellStock6WithTransactionFeeSpaceOpt {

	public static void main(String args[]) {

		int prices[] = { 1, 3, 2, 8, 4, 9 };
		int n = prices.length;
		int fee = 2;

		System.out.println("The maximum profit that can be generated is " + maximumProfit(n, fee, prices));
	}

	static long maximumProfit(int n, int fee, int[] Arr) {
		if (n == 0)
			return 0;

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
					profit = Math.max(0 + ahead[1], Arr[ind] - fee + ahead[0]);
				}
				cur[buy] = profit;
			}

			ahead = (long[]) (cur.clone());
		}
		return cur[0];
	}
}
