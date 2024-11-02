package sorting;

import java.util.HashMap;

public class TargetSumPair {
    public static void main(String[] args) {
        int[] res = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int h : res) {
            System.out.print(h + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int p = 0; p < nums.length - 1; p++) {
            hm.put(nums[p], p);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hm.containsKey(complement) && hm.get(complement) != i) {
                return new int[]{i, hm.get(complement)};
            }
        }
        return null;
    }
}
