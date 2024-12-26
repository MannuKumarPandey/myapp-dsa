package dynamicprogramming;

public class RodCuttingProblemSpaceOptimized {

	public static void main(String args[]) {

		int price[] = { 2, 5, 7, 8, 10 };

		int n = price.length;

		System.out.println("The Maximum price generated is " + cutRod(price, n));
	}

	static int cutRodUtil(int price[], int ind, int N, int[][] dp) {

		if (ind == 0) {
			return N * price[0];
		}

		if (dp[ind][N] != -1)
			return dp[ind][N];

		int notTaken = 0 + cutRodUtil(price, ind - 1, N, dp);

		int taken = Integer.MIN_VALUE;
		int rodLength = ind + 1;
		if (rodLength <= N)
			taken = price[ind] + cutRodUtil(price, ind, N - rodLength, dp);

		return dp[ind][N] = Math.max(notTaken, taken);
	}

	static int cutRod(int[] price, int N) {

		int cur[] = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			cur[i] = i * price[0];
		}

		for (int ind = 1; ind < N; ind++) {
			for (int length = 0; length <= N; length++) {

				int notTaken = 0 + cur[length];

				int taken = Integer.MIN_VALUE;
				int rodLength = ind + 1;
				if (rodLength <= length)
					taken = price[ind] + cur[length - rodLength];

				cur[length] = Math.max(notTaken, taken);
			}
		}

		return cur[N];
	}
}
