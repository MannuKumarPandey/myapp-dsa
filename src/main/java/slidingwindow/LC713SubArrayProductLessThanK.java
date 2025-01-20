package slidingwindow;

import java.util.Arrays;

public class LC713SubArrayProductLessThanK {

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k == 0) {
            return 0;
        }

        int n = nums.length;

        int result = 0;
        Arrays.sort(nums);// 2 5 6 10
        int i = 0;
        while (i < n) {
            int curP = 1;
            int j = i;
            while (j < n && curP < k) {
                if (curP * nums[j] < k) {
                    curP *= nums[j];
                    j++;
                } else {
                    break;
                }
            }

            int x = j - i;
            result = result + (x*(x+1)/2);
            i = j;
        }

        return result;
    }
}
