package MandeepDSA200Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18FourSum {


    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> result = fourSum(nums, target);
        System.out.println(result); // Expected: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //agar nums.length <4 ho tab
        if (nums == null || nums.length < 4) return result;

        // Step 1: Sort the array
        Arrays.sort(nums);

        int n = nums.length;

        // Step 2: Iterate through the array with two loops
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate elements for the first index
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate elements for the second index
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Step 3: Two-pointer technique for the remaining two numbers
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        // Add the quadruplet to the result
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Move pointers to avoid duplicates
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // Increase the sum
                    } else {
                        right--; // Decrease the sum
                    }
                }
            }
        }

        return result;
    }


}
