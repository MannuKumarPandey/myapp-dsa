package recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubSetSumProblem1 {

	public static void allSubSetSum(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubSet) {
		if (ind == N) {
			sumSubSet.add(sum);
			return;
		}

		// pick the element
		allSubSetSum(ind + 1, sum + arr.get(ind), arr, N, sumSubSet);

		// Do not pick the element
		allSubSetSum(ind + 1, sum, arr, N, sumSubSet);
	}

	public static void main(String[] args) {

		int[] temp = { 3, 2 };
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int h : temp) {
			arr.add(h);
		}
		int N = 2;
		ArrayList<Integer> sumSubSet = new ArrayList<Integer>();
		allSubSetSum(0, 0, arr, N, sumSubSet);
		Collections.sort(sumSubSet);

		for (int h : sumSubSet) {
			System.out.print(h + " ");
		}
		System.out.println();
	}
}
