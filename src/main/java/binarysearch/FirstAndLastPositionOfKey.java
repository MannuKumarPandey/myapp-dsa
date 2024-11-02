package binarysearch;

import java.util.Arrays;

public class FirstAndLastPositionOfKey {

    public static void main(String[] args) {
        int arr[] = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for (int l : arr) {
            System.out.print(l + " ");
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int result[] = new int[2];
        Arrays.fill(result, -1);
        if (nums.length == 1 && target == nums[0]) {
            Arrays.fill(result, 0);
            return result;
        }
        if (nums.length == 0 || (nums.length == 1 && target != nums[0])) {
            return result;
        }
        result[0] = binarySearchModIterative(0, nums.length - 1, nums, false, target);
        result[1] = binarySearchModIterative(0, nums.length - 1, nums, true, target);
        return result;
    }

    public static int binarySearchModIterative(int start, int end, int arr[], boolean direction, int target) {
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                if (direction == false) {
                    res = mid;
                    end = mid - 1;

                } else {
                    res = mid;
                    start = mid + 1;
                }
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            }
        }
        return res;
    }
}
