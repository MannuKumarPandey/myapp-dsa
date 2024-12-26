package MandeepDSA200HARD;

import java.util.ArrayList;

public class LC312BurstBaloonDP {

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
    }


    public static int maxCoins(int[] nums) {
        int n = nums.length;
        //we are considering that our i and j both are getting changed
        int[][] dp = new int[nums.length + 1][nums.length + 1];//first index for i and second indexx for j

        //initializing as -1
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }


        //Adding 1 at both the end so that corner elements can be also taken care in normal way
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        for (int i = 0; i < n; i++) {
            arr.add(nums[i]);
        }
        arr.add(1);



        return helper(1, n, arr, dp); //[1, 3, 1, 5, 8, 1]
    }

    public static int helper(int i, int j, ArrayList<Integer> a, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;

        for (int curInd = i; curInd <= j; curInd++) {
            //consider yah kar rahe hai ki curInd sabse last me burst kiya iska matlab wo apane se pahle wale sare operations me rahega and
            //wo apane se left walo ke liye right ban jayega and apane se bad walo ke liye left ban jayega jiski vajah se apane left and right sabko
            //independent sub problem me convert kar dega.
            int cost = a.get(i - 1) * a.get(curInd) * a.get(j + 1) + helper(i, curInd - 1, a, dp) + helper(curInd + 1, j, a, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }
}
