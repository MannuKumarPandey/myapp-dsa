package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPossiblePermutationsOfAnArrayUsingOnlyRecursions {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        util(result, tempRes, arr, used);
        System.out.println(result.size());
        System.out.println(result.toString());
    }

    public static void util(List<List<Integer>> result, List<Integer> tempRes, int[] arr, boolean[] used) {
        if (tempRes.size() == arr.length) {
            result.add(new ArrayList<>(tempRes));
            return;
        }

        utilDetails(result, tempRes, arr, used, 0);
    }

    private static void utilDetails(List<List<Integer>> result, List<Integer> tempRes, int[] arr, boolean[] used,
                                    int index) {
        if (index == arr.length) {
            return;
        }

        if (!used[index]) {
            tempRes.add(arr[index]);
            used[index] = true;
            util(result, tempRes, arr, used);
            tempRes.remove(tempRes.size() - 1); // Backtrack
            used[index] = false;
        }

        utilDetails(result, tempRes, arr, used, index + 1);
    }

}

