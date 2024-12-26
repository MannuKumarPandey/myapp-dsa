package stack;

public class BestTimeToBuySellStock1 {
    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }


    /*Here allowed conditions are
            1) Before sell we must buy the stock.
            2) Only one time buy and sell is required
            3) Try to maximize the profit.
        */


    public static int maxProfit1(int[] prices) {
        int result = 0;
        int minSoFar = prices[0];
        for (int i = 0; i < prices.length; i++) {

            minSoFar = Math.min(minSoFar, prices[i]);

            int profit = prices[i] - minSoFar;

            result = Math.max(result, profit);
        }
        return result;
    }

// but this approach is taking O(n) space as well which is getting reduced in maxProfit1 example
    public static int maxProfit2(int[] prices) {
        int result = 0;
        int len = prices.length;
        int[] minArrayFromLeft = new int[len];
        int[] maxArrayFromRight = new int[len];

        minArrayFromLeft[0] =  prices[0];
        maxArrayFromRight[len-1] = prices[len-1];

        for(int i = 1; i<len ; i++){
            minArrayFromLeft[i] = Math.min(prices[i], minArrayFromLeft[i-1]);
        }

        for(int i = len-2; i>=0 ; i--){
            maxArrayFromRight[i] = Math.max(prices[i], maxArrayFromRight[i+1]);
        }

        for(int i = 0; i<len; i++){
            result = Math.max(result, maxArrayFromRight[i] - minArrayFromLeft[i]);
        }

        return result;
    }

}
