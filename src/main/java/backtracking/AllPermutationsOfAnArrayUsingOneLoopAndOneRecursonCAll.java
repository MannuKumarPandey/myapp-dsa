package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOfAnArrayUsingOneLoopAndOneRecursonCAll {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();
        util(result, tempRes, arr, 0);
        System.out.println(result.size());
        System.out.println(result.toString());
    }

    public static void util(List<List<Integer>> result, List<Integer> tempRes, int[] arr, int index) {

        if (tempRes.size() == arr.length) {
            result.add(new ArrayList<>(tempRes));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!tempRes.contains(arr[i])) {
                tempRes.add(arr[i]);
                util(result, tempRes, arr, i + 1);
                tempRes.remove(tempRes.size() - 1); // Backtrack
            }
        }
    }

}
