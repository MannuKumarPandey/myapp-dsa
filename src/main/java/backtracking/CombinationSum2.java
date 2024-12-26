package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 6, 7};
        Arrays.sort(arr);
        int target = 18;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();
        util(result, tempRes, arr, 0, 0, target);
        System.out.println(result.toString());
    }

    public static void util(List<List<Integer>> result, List<Integer> tempRes, int arr[], int index, int tempSum,
                            int target) {

        if (tempSum > target) {
            return;
        }

        if (tempSum == target) {
            result.add(new ArrayList<Integer>(tempRes));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {   // skip continuation for duplications
                continue;
            }
            tempRes.add(arr[i]);
            util(result, tempRes, arr, i + 1, tempSum + arr[i], target);
            tempRes.remove(tempRes.size() - 1);

        }
    }

}

