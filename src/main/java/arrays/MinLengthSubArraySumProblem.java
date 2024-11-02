package arrays;

public class MinLengthSubArraySumProblem {


    public static void main(String[] args) {
        System.out.println(minSubArrayLen(15, new int[]{2, 14}));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int numsLength = nums.length;
        int[] prefix = new int[numsLength];
        prefix[0] = nums[0];
        for (int i = 0; i < numsLength - 1; i++) {
            prefix[i + 1] = prefix[i] + nums[i + 1];
        }

        if (prefix[numsLength - 1] == target) {
            return numsLength;
        }
        int res = Integer.MAX_VALUE;

        int i = 0;
        int j = i;
        if (prefix[0] >= target) {
            res = Math.min(res, j + 1);
        }
        j = j + 1;
        while (i < numsLength - 1 && j < numsLength) {
            if (prefix[j] == target) {
                res = Math.min(res, j + 1);
                i = j;
                j = j + 1;
            } else if (prefix[j] - prefix[i] < target && prefix[j] > target) {
                res = Math.min(res, j + 1);
                j++;
            } else if (prefix[j] - prefix[i] < target) {
                j++;
            } else if (prefix[j] - prefix[i] > target) {
                res = Math.min(res, j - i);
                i++;
            } else {
                res = Math.min(res, j - i);
                i++;
                j++;
            }
        }
        return res != Integer.MAX_VALUE ? res : 0;
    }
}
