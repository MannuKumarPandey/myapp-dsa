package MandeepDSA200HARD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC2122RecoverArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(recoverArray(new int[]{2, 10, 6, 4, 8, 12})));
    }

    public static int[] recoverArray(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        int len = nums.length;
        int originalSize = len / 2;

        // Try different values of k (must be positive and even)
        for (int i = 0; i < len-1; i++) {
            int diff = nums[len-1] - nums[i];
            if (diff % 2 != 0 || diff == 0) continue; // k must be a positive integer

            int k = diff / 2;
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            int[] original = new int[originalSize];
            int idx = 0;
            boolean valid = true;

            // Try forming the original array
            for (int num : nums) {
                if (freqMap.getOrDefault(num, 0) == 0) continue; // Already used
                if (freqMap.getOrDefault(num + 2 * k, 0) == 0) {
                    valid = false;
                    break;
                }

                // Form pair (num, num + 2k)
                original[idx++] = num + k;
                freqMap.put(num, freqMap.get(num) - 1);
                freqMap.put(num + 2 * k, freqMap.get(num + 2 * k) - 1);
            }

            if (valid) return original;
        }

        return new int[0]; // Should never reach here based on problem constraints
    }
}
