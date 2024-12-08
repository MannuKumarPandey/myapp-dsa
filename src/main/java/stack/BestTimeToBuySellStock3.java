package stack;

public class BestTimeToBuySellStock3 {

    public static void main(String[] args) {
        System.out.println(new BuySellStock().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));

    }
    /*Here allowed conditions are
            1) We can do maximum of 2 transactions.
            2)Prices might be duplicates as well.
            3)And if we buy any stock so we must sell that before buying any other stock.
            4) Try to maximize the profit.
    */

}

class BuySellStock {
    int[][][] dp;

    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2][3];
        for (int i = 0; i <= prices.length; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(0, 1, prices, 2);
    }


    // buy -> 0 i.e nope cant buy
    // buy -> 1 i.e yes can buy

    public int solve(int index, int buy, int[] prices, int transactionCapacity) {
        if (index == prices.length || transactionCapacity == 0) {
            return 0;
        }

        if (dp[index][buy][transactionCapacity] != -1) {
            return dp[index][buy][transactionCapacity];
        }


        if (buy == 1) {
            return dp[index][buy][transactionCapacity] =
                    Math.max(-prices[index] + solve(index + 1, 0, prices, transactionCapacity),
                            solve(index + 1, 1, prices, transactionCapacity));
        } else {
            return dp[index][buy][transactionCapacity] =
                    Math.max(prices[index] + solve(index + 1, 1, prices, transactionCapacity - 1),
                            solve(index + 1, 0, prices, transactionCapacity));
        }
    }
}
