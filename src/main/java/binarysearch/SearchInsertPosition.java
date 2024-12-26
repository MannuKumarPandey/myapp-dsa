package binarysearch;

public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    public static int searchInsert(int[] nums, int target) {

        if (nums[0] > target) {
            return 0;
        }
        int start = 0;
        int last = nums.length - 1;

        int position = -1;
        int mid = 0;
        while (start <= last) {
            mid = (start + last) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return start;
    }
}
