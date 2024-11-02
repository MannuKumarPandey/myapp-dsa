package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleSubSetTargetSumBT {

    public static void main(String[] args) {
        int[] arr = new int[]{26, 21, 39, 38, 24, 16, 30, 7, 5, 4, 9, 29, 8, 35, 3, 17, 19, 11, 34};
        int target = 29;
        List<List<Integer>> res = allPossibleCom(arr, target);
        System.out.println("total possible combinations ::::" + res.size());
        System.out.println(res.toString());
    }

    public static List<List<Integer>> allPossibleCom(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        allPossibleComHelper(nums, 0, ans, target, new ArrayList<>());
        return ans;
    }

    public static void allPossibleComHelper(int[] nums, int idx, List<List<Integer>> ans, int target, List<Integer> currans) {
        // am I missing any base conditions here ? why post backtrack line we are not calling recursion again?
        if (target == 0) {
            System.out.println(currans);
            ans.add(new ArrayList<>(currans)); // Add a copy of currans to ans
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            // Include the current element
            currans.add(nums[i]);
            allPossibleComHelper(nums, i, ans, target - nums[i], currans);

            currans.remove(currans.size() - 1); // Backtrack
            // Exclude the current element
            //allPossibleComHelper(nums, idx + 1, ans, target,  currans);
        }
    }
}

