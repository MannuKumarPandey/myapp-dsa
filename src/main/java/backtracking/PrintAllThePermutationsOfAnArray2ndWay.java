package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllThePermutationsOfAnArray2ndWay {

	// This is approach 2 for all permutations of given array which generally takes
	// Time complexity : O(N! * n)
	// Space complexity : O(n)
	// In This example we are using swapping technique where extra space to keep the
	// freq array
	// was not required
	public static void main(String[] args) {
		int array[] = { 2, 1, 3 };
		List<List<Integer>> ans = allPermutations(array);

		for (List<Integer> h : ans) {
			for (int j : h) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	private static List<List<Integer>> allPermutations(int[] array) {
		List<List<Integer>> ans = new ArrayList<>();
		getAllPermutations(0, array, ans);
		return ans;
	}

	private static void getAllPermutations(int index, int[] array, List<List<Integer>> ans) {

		// Base condition
		if (index == array.length) {
			// copy the ds to ans
			List<Integer> ds = new ArrayList<Integer>();
			for (int i = 0; i < array.length; i++) {
				ds.add(array[i]);
			}
			ans.add(new ArrayList<>(ds));
			return;
		}

		// for all the values available in array
		for (int i = index; i < array.length; i++) {
			swap(i, index, array);
			getAllPermutations(index + 1, array, ans);
			swap(i, index, array);
		}
	}

	private static void swap(int i, int index, int[] array) {
		int t = array[i];
		array[i] = array[index];
		array[index] = t;
	}
}
