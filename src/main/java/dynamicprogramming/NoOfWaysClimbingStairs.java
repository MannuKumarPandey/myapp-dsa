package dynamicprogramming;

import java.util.Arrays;

public class NoOfWaysClimbingStairs {
    static int[] dp = new int[2 + 1];

    public static void main(String[] args) {
        Arrays.fill(dp, -1);
        System.out.println(climbStairs(2));
    }

    public static int climbStairs(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }
}

