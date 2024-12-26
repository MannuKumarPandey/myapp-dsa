package slidingwindow;

public class LC2762ContinousSubArrays {


    public static void main(String[] args) {
        System.out.println(continuousSubarrays(new int[]{5, 4, 2, 4}));
    }

    public static long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int left = 0; //to track the starting point of the window
        int rangeMin = Integer.MAX_VALUE;
        int rangeMax = Integer.MIN_VALUE;

        long count = 0;
        long winSize;
        int right; //to track the right point of the window

        for (right = 0; right < n; right++) {

            //if rangeMax and rangeMin ka absolute difference 2 se chhota hai
            rangeMin = Math.min(rangeMin, nums[right]);
            rangeMax = Math.max(rangeMax, nums[right]);

            //if rangeMax and rangeMin ka absolute difference 2 se bada hai
            if (rangeMax - rangeMin > 2) {
                //calculate window size
                winSize = right - left;
                //calculate the total number of subarrrays by formula (n*(n+1)/2)
                count += (winSize * (winSize + 1)) / 2;

                ///now update the left to right
                left = right;

               //update the rangeMin and rangeMax from right pointer itself
                rangeMin = nums[right];
                rangeMax = nums[right];

                // Expand current window to as left as possible
                while (left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2) {
                    left--;
                    rangeMin = Math.min(rangeMin, nums[left]);
                    rangeMax = Math.max(rangeMax, nums[left]);
                }

                // Subtract overcounted subarrays
                if (left < right) {
                    winSize = right - left;
                    count -= (winSize * (winSize + 1)) / 2;
                }
            }
        }
        // Add subarrays from the last window
        winSize = right - left;
        count += (winSize * (winSize + 1)) / 2;

        return count;
    }
}
