package MandeepDSA200Medium;

public class LC918CircularSubArrayMaxSum {

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
    }


    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        // max sum pure array me
        int maxSum = Integer.MIN_VALUE;
        int currMax = 0;
        for (int i = 0; i < n; i++) {
            currMax += nums[i];
            maxSum = Math.max(maxSum, currMax);
            if (currMax < 0) {
                currMax = 0;
            }
        }


        //min sum pure array me
        int minSum = Integer.MAX_VALUE;
        int currMin = 0;
        for (int i = 0; i < n; i++) {
            currMin += nums[i];
            minSum = Math.min(minSum, currMin);
            if (currMin > 0) {
                currMin = 0;
            }
        }


        //total sum
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }


        if (maxSum < 0) {
            return maxSum;
        } else {
            return Math.max(maxSum, total - minSum);
        }
    }
}
