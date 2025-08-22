package backtracking;

import java.util.ArrayList;
import java.util.List;

class AllPOssibleSubSets {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetHelper(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void subsetHelper(int[] nums, int start, List<List<Integer>> ans, List<Integer> tempAns) {

            ans.add(new ArrayList<>(tempAns)); // Add a copy of tempAns to final Ans. if we directly add then all


        //combination of Iteration plus Recursive
        for (int i = start; i < nums.length; i++) {  //loop
            // If we Include the current element
            tempAns.add(nums[i]); //data ka temporary add hona
            subsetHelper(nums, i + 1, ans, tempAns);//loop

            tempAns.remove(tempAns.size() - 1); // Backtrack added daqta ka hatana
        }

    }
}

