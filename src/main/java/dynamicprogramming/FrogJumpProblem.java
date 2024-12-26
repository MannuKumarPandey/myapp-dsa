package dynamicprogramming;

public class FrogJumpProblem {

	public static void main(String[] args) {
		int array[] = { 30, 10, 60, 10, 60, 50 };
		int n = 6;
		int dp[] = new int[6];
		for (int i = 0; i < n; i++) {
			dp[i] = -1;
		}
		System.out.println(findMinEnergy(array, n - 1, dp));
	}

	private static int findMinEnergy(int[] array, int index, int[] dp) {

		if (index == 0) {
			return 0;
		}

		if (dp[index] != -1) {
			return dp[index];
		}

		int leftRes = findMinEnergy(array, index - 1, dp) + Math.abs(array[index] - array[index - 1]);
		int rightRes;
		if (index > 1) {
			rightRes = findMinEnergy(array, index - 2, dp) + Math.abs(array[index] - array[index - 2]);
		} else {
			rightRes = Integer.MAX_VALUE;
		}
		return dp[index] = Math.max(leftRes, rightRes);
	}
}
