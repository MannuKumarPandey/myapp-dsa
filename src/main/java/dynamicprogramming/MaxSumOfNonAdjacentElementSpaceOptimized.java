package dynamicprogramming;

public class MaxSumOfNonAdjacentElementSpaceOptimized {

	// This approach is taking
	// TC : O(N) and SC : O(1)

	public static void main(String[] args) {
		int array[] = { 2, 1, 4, 9 };
		int n = array.length;
		System.out.println(solve(n, array));
	}

	private static int solve(int n, int[] arr) {
		int prev = arr[0];
		int prev2 = 0;

		for (int i = 1; i < n; i++) {
			int pick = arr[i];
			if (i > 1)
				pick += prev2;
			int nonPick = 0 + prev;

			int cur_i = Math.max(pick, nonPick);
			prev2 = prev;
			prev = cur_i;

		}
		return prev;
	}
}
