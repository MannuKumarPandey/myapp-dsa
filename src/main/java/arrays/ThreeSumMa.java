package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSumMa {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            List<Integer> local = new ArrayList<>();
            int cur = nums[i];
            int localSum = -cur;
            int[] resL = twoSum(nums, localSum, i + 1, nums.length);
            if (resL != null) {
                local.add(cur);
                local.add(resL[0]);
                local.add(resL[1]);
                result.add(local);
            }

        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target, int start, int end) {

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int p = start; p < end; p++) {
            hm.put(nums[p], p);
        }
        for (int i = start; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hm.containsKey(complement) && hm.get(complement) != i) {
                return new int[]{nums[i], nums[hm.get(complement)]};
            }
        }
        return null;
    }
}

