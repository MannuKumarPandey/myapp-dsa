package binarysearch;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            //matlab left part sorted hai
            if (nums[start] <= nums[mid]) {
                // matlab isi half me value hai
                if (nums[start] <= target && nums[mid] > target) {
                    end = mid - 1;
                } else {// varna isme values nahi hai to aage jaye
                    start = mid + 1;
                }
            } else {//matlab right half sorted hai
                if (nums[mid] < target && target <= nums[end]) {//iska matlab target isi me hai
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

}
