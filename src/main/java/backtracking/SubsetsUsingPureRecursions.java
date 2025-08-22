package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsUsingPureRecursions {


    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetHelper(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void subsetHelper(int[] nums, int start, List<List<Integer>> ans, List<Integer> tempAns) {
        if (start == nums.length) {
            ans.add(new ArrayList<>(tempAns));
            return;
        }

        tempAns.add(nums[start]);//pahle data ka jutna
        subsetHelper(nums, start + 1, ans, tempAns);//recursive call

        tempAns.remove(tempAns.size() - 1); // Backtrack data ka hatana
        subsetHelper(nums, start + 1, ans, tempAns);//recursive call


    }
}
