package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllCombinationsSumTarget {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 7};
        Arrays.sort(arr);
        int target = 7;
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
            result.add(new ArrayList<>(tempRes));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            tempRes.add(arr[i]);
            util(result, tempRes, arr, i, tempSum + arr[i], target);
            tempRes.remove(tempRes.size() - 1);

        }
    }

}

