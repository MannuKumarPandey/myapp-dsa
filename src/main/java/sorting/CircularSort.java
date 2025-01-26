package sorting;

public class CircularSort {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + firstMissingPositive(nums));

        int[] nums2 = {1, 2, 0};
        System.out.println("First Missing Positive: " + firstMissingPositive(nums2));

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println("First Missing Positive: " + firstMissingPositive(nums3));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Cyclic sort
        for (int i = 0; i < n; ) {
            if (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] to its correct position
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {

                i++;
            }
        }

        // Step 2: Identify the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // Missing positive
            }
        }

        // If all positions are correct, return n + 1
        return n + 1;
    }


}
