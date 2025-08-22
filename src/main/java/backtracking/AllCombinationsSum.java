package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllCombinationsSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7).toString());
    }

    public static void allPossibleComHelper(int[] candidates, int idx, List<List<Integer>> ans, int target, List<Integer> currans) {
        if (target == 0) {
            ans.add(new ArrayList<>(currans)); // Add a copy of currans to ans
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {

            // Include the current element
            currans.add(candidates[i]);
            allPossibleComHelper(candidates, i, ans, target - candidates[i], currans);
            currans.remove(currans.size() - 1); // Backtrack

        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        allPossibleComHelper(candidates, 0, ans, target, new ArrayList<>());
        return ans;
    }

}
