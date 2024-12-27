package alltemplates;


import java.util.ArrayList;
import java.util.List;

public class BackTrackingBasic {
    public void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> result, int start) {
        result.add(new ArrayList<>(temp)); // Add current state to the result

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]); // Choose
            backtrack(nums, temp, result, i + 1); // Explore
            temp.remove(temp.size() - 1); // Un-choose
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, 0);
        return result;
    }
}
