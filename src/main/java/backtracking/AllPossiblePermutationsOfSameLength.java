package backtracking;

import java.util.ArrayList;
import java.util.List;

class AllPossiblePermutationsOfSameLength {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{2, 3, 5, 6}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteHelper(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void permuteHelper(int[] nums, int start, List<List<Integer>> ans, List<Integer> tempAns) {
        if (tempAns.size() == 4) {
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        // If we Include the current element
        for (int i = 0; i < nums.length; i++) {
            if (!tempAns.contains(nums[i])) {
                tempAns.add(nums[i]);
                permuteHelper(nums, i + 1, ans, tempAns);
                tempAns.remove(tempAns.size() - 1); // Backtrack
            }
        }
    }
}

