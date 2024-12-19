package arrays;

public class LongestStrictlyIncreasingOrDecreasing {

    public static void main(String[] args) {
        System.out.println(longestMonotonicSubarray(new int[]{3, 2, 1}));
    }

    public static int longestMonotonicSubarray(int[] nums) {
        int increasingL = 0;
        int i = 0;
        int len = nums.length;

        while (i < len - 1) {
            int tempL = 1;
            int j = i + 1;
            while (j < len) {
                if (nums[i] < nums[j]) {
                    tempL++;
                    i++;
                    j++;
                    increasingL = Math.max(increasingL, tempL);
                } else {
                    i++;
                    increasingL = Math.max(increasingL, tempL);
                    break;
                }
            }
        }

        int decreasingL = 0;
        i = 0;
        len = nums.length;

        while (i < len - 1) {
            int tempL = 1;
            int j = i + 1;
            while (j < len) {
                if (nums[i] > nums[j]) {
                    tempL++;
                    i++;
                    j++;
                    decreasingL = Math.max(decreasingL, tempL);
                } else {
                    i++;
                    decreasingL = Math.max(decreasingL, tempL);
                    break;
                }
            }
        }
        return Math.max(increasingL, decreasingL);
    }
}
