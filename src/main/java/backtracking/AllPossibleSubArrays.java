package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleSubArrays {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 4, 2, 5, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetHelper(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void subsetHelper(int[] nums, int start, List<List<Integer>> ans, List<Integer> tempAns) {
        if (start == nums.length && tempAns.size() % 2 != 0) {
            ans.add(new ArrayList<>(tempAns)); // Add a copy of tempAns to final Ans. if we directly add then all entries values will be same.
            return;
        }

        if (start == nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (!tempAns.contains(nums[i])) {
                // If we Include the current element
                tempAns.add(nums[i]);
                subsetHelper(nums, i + 1, ans, tempAns);
                tempAns.remove(tempAns.size() - 1); // Backtrack
            }
        }
    }
}

