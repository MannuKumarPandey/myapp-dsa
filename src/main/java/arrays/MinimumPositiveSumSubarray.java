package arrays;

import java.util.Arrays;
import java.util.List;

public class MinimumPositiveSumSubarray {

    public static void main(String[] args) {
        System.out.println(minimumSumSubarray(Arrays.asList(3, -2, 1, 4), 2, 3));
    }

    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int result = Integer.MAX_VALUE;
        int len = nums.size();
        for (int i = 0; i < len; i++) {
            int tempSum = 0;
            for (int j = i; j < len; j++) {
                if (j == i + l) {
                    break;
                } else {
                    tempSum += nums.get(j);
                }
            }
            if (tempSum > 0) {
                result = Math.min(result, tempSum);
            }
        }

        for (int i = 0; i < len; i++) {
            int tempSum = 0;
            for (int j = i; j < len; j++) {
                if (j == i + r) {
                    break;
                } else {
                    tempSum += nums.get(j);
                }
            }
            if (tempSum > 0) {
                result = Math.min(result, tempSum);
            }
        }
        return result;

    }
}
