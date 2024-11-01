package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumProblem2SecondWay {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 6, 7, 1 };
		int target = 7;

		List<List<Integer>> ls = combinationSum(arr, target);
		// List<List<Integer>> to store the final results
		System.out.println("Combinations are: ");
		for (int i = 0; i < ls.size(); i++) {
			for (int j = 0; j < ls.get(i).size(); j++) {
				System.out.print(ls.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {

		if (target == 0) {
			ans.add(new ArrayList<>(ds));
		}

		for (int i = ind; i < arr.length; i++) {
			if (i > ind && arr[i] == arr[i - 1])
				continue;
			if (arr[i] > target) {
				break;
			}

			ds.add(arr[i]);
			findCombinations(i + 1, arr, target - arr[i], ans, ds);
			ds.remove(ds.size() - 1);
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(candidates);
		findCombinations(0, candidates, target, ans, new ArrayList<>());
		return ans;
	}

}
