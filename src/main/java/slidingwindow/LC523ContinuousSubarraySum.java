package slidingwindow;

import java.util.HashMap;

public class LC523ContinuousSubarraySum {
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23,2,6,4,7},6));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remainder = prefixSum % k;

            if (map.containsKey(remainder)) {

                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

}
