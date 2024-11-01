package dynamicprogramming;

public class FrogJumpKthIndex {

	public static void main(String[] args) {
		int array[] = { 30, 10, 60, 10, 60, 50, 10 };
		int n = 6;
		int k = 5;
		int minEnergy = Integer.MAX_VALUE;
		int dp[] = new int[6];
		for (int i = 0; i < n; i++) {
			dp[i] = -1;
		}
		System.out.println(findMinEnergy(array, n - 1, dp, k, minEnergy));
	}

	private static int findMinEnergy(int[] array, int index, int[] dp, int k, int minEnergy) {

		if (index == 0) {
			return 0;
		}

		if (dp[index] != -1) {
			return dp[index];
		}

		for (int j = 1; j <= k; j++) {
			if (index - j >= 0) {
				minEnergy = Math.min(minEnergy,
						findMinEnergy(array, index - j, dp, k, minEnergy) + Math.abs(array[index] - array[index - j]));
			}
		}
		return dp[index] = minEnergy;
	}

}
