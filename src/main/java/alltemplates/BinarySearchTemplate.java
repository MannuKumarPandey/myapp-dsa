package alltemplates;

public class BinarySearchTemplate {
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Found target
            } else if (nums[mid] < target) {
                left = mid + 1; // Narrow to right half
            } else {
                right = mid - 1; // Narrow to left half
            }
        }
        return -1; // Target not found
    }
}

