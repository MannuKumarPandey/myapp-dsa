package DSA200HARD;

public class LC123BuySell3 {


    static int[][][] dp;

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    public static int maxProfit(int[] prices) {

        dp = new int[prices.length + 1][2][3];
        // first dimension : current index of prices array
        //second dimension is keeping flag information means wheter we are able to buy the stock or not: if its value is 1  we can buy else not.
        //third dimension: how many operations are yet available


        //initializing every thing with -1
        for (int i = 0; i <= prices.length; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }


        return solve(0, 1, prices, 2);
    }

    // if buy value is 1 means we can buy the stock
    public static int solve(int index, int buy, int[] prices, int cap) {

        //base case reches means it will stocp and return profit as 0 here
        if (index == prices.length || cap == 0) {
            return 0;
        }

        //if dp array is keeping the value already : return that profit
        if (dp[index][buy][cap] != -1) {
            return dp[index][buy][cap];
        }

        if (buy == 1) {
            return dp[index][buy][cap] = Math.max(solve(index + 1, 0, prices, cap) - prices[index], solve(index + 1, 1, prices, cap));
        } else {
            return dp[index][buy][cap] = Math.max(prices[index] + solve(index + 1, 1, prices, cap - 1), solve(index + 1, 0, prices, cap));
        }
    }

}
