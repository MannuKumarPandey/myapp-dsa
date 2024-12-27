package alltemplates;

public class SlidingWindowFixedSize {
    public int maxSumSubarray(int[] nums, int k) {
        int maxSum = 0, windowSum = 0;

        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];

            if (i >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[i - (k - 1)];
            }
        }
        return maxSum;
    }

}
