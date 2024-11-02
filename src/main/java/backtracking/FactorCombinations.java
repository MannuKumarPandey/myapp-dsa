package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorCombinations {
    public static void main(String[] args) {
        int n = 12;
        ArrayList<Integer> factors = getFactors(n);
        int[] arr = new int[factors.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = factors.get(i);
        }
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();
        util(result, tempRes, arr, 0, 0, n);
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
            if (i > index && arr[i] == arr[i - 1]) { // skip continuation for duplications
                continue;
            }
            tempRes.add(arr[i]);
            util(result, tempRes, arr, i + 1, tempSum + arr[i], target);
            tempRes.remove(tempRes.size() - 1);

        }
    }

    public static ArrayList<Integer> getFactors(int target) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        for (int i = 1; i <= Math.sqrt(target); i++) {

            if (target % i == 0) {
                if (i == (target / i)) {
                    arrList.add(i);
                } else {
                    arrList.add(i);
                    arrList.add(target / i);
                }
            }
        }

        return arrList;
    }
}
