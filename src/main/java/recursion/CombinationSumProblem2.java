package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CombinationSumProblem2 {

	// only unique elements not in repetedly manner

	public static void main(String[] args) {
		int arr[] = { 2, 3, 6, 7 };
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

	private static void findCombinations(int ind, int[] arr, int target, HashSet<ArrayList<Integer>> ans, ArrayList<Integer> ds) {
		if (ind == arr.length) {
			if (target == 0) {
				ans.add(new ArrayList<>(ds));
			}
			return;
		}

		if (arr[ind] <= target) {
			ds.add(arr[ind]);
			findCombinations(ind+1, arr, target - arr[ind], ans, ds);
			ds.remove(ds.size() - 1);
		}
		findCombinations(ind + 1, arr, target, ans, ds);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> temp = new ArrayList<>();
		HashSet<ArrayList<Integer>> ans = new HashSet<ArrayList<Integer>>();
		findCombinations(0, candidates, target, ans, new ArrayList<>());
		for(ArrayList<Integer> hh: ans) {
			temp.add(hh);
		}
		return temp;
	}



}
