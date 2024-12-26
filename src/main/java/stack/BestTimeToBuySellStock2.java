package stack;

public class BestTimeToBuySellStock2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

    }


    /*Here allowed conditions are
            1) We can hold only one stock at a time.
            means if we buy any stock so we must sell that before buying any other stock.
            2) We can buy and sell any number of time
            3) Try to maximize the profit.
        */

    //Iska main aim yah hai ki hame profit tab hi milega jab current index ki value pichale wale se badi hi aur uske
    //difference ke barabar hame profit milate rahega.

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;

    }

}
