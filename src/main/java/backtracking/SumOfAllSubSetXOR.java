package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubSetXOR {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{5, 1, 6}).toString());
        List<List<Integer>> lists = subsets(new int[]{1, 3});
        int total = 0;
        for (List<Integer> temp : lists) {
            int res = 0;
            for (int k : temp) {
                res = res ^ k;
            }
            total = total + res;
        }

        System.out.println(total);
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
        // If we Include the current element
        tempAns.add(nums[start]);
        subsetHelper(nums, start + 1, ans, tempAns);
        tempAns.remove(tempAns.size() - 1); // Backtrack
        subsetHelper(nums, start + 1, ans, tempAns);
    }
}
