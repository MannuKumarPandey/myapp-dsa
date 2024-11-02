package arrays;

public class StockBuyAndSellMultipletimes {

    public static void main(String[] args) {

        int[] prices = new int[] { 5, 6, 9, 1, 2, 3, 4, 2, 3, 7 };

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        System.out.println(profit);
    }
}


