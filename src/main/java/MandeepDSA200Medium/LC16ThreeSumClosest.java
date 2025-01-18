package MandeepDSA200Medium;

import java.util.Arrays;

public class LC16ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {

        int result = 0;
        int d = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int t = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - t);
                if (diff < d) {
                    d = diff;
                    result = t;
                }

                if (t == target) {
                    return target;
                } else if (t > target) {
                    k--;
                } else if (t < target) {
                    j++;
                }
            }
        }
        return result;
    }
}
