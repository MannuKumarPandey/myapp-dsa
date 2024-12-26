package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllThePermutationsOfAnArray {
	// This is approach 1 for all permutations of given array which generally takes
	// Time complexity : O(N! * n)
	// Space complexity : O(n) + O(n)
	// In next example space complexity optimization is also done just to take o(n)
	// as space complexity
	public static void main(String[] args) {
		int[] array = { 2, 1, 3 };
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
		List<Integer> ds = new ArrayList<Integer>();
		boolean[] freq = new boolean[array.length];
		getAllPermutations(array, ds, ans, freq);
		return ans;
	}

	private static void getAllPermutations(int[] array, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {

		// Base condition
		if (ds.size() == array.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		// for all the values available in array
		for (int i = 0; i < array.length; i++) {
			if (!freq[i]) { // check if same index is already taken or not
				freq[i] = true;
				ds.add(array[i]);
				getAllPermutations(array, ds, ans, freq);
				// while coming back from the recusrion call end
				// please remove the last added element from the ds
				// and also mark respective freq as not visited from freq array.
				ds.remove(ds.size() - 1);
				freq[i] = false;
			}
		}
	}
}
