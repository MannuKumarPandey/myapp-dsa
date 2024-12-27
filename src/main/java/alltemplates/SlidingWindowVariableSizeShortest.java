package alltemplates;

public class SlidingWindowVariableSizeShortest {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, minLength = Integer.MAX_VALUE, windowSum = 0;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            while (windowSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                windowSum -= nums[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
