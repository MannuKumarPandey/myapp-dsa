package dynamicprogramming;

import java.util.Arrays;

public class EditDistanceMemoization {

	public static void main(String args[]) {

		String s1 = "horse";
		String s2 = "ros";

		System.out.println("The minimum number of operations required is: " + editDistance(s1, s2));
	}

	static int editDistance(String S1, String S2) {

		int n = S1.length();
		int m = S2.length();

		int[][] dp = new int[n][m];
		for (int row[] : dp)
			Arrays.fill(row, -1);
		return editDistanceUtil(S1, S2, n - 1, m - 1, dp);

	}

	static int editDistanceUtil(String S1, String S2, int i, int j, int[][] dp) {

		if (i < 0)
			return j + 1;
		// agar first string khatam ho gya to jha j second string me hai usase 1 extra
		// insertions karna padega
		if (j < 0)
			// jab second string khatam ho jayega to jha i first string me hoga usase ek
			// extra deletion karna padega
			return i + 1;

		if (dp[i][j] != -1)
			return dp[i][j];

		if (S1.charAt(i) == S2.charAt(j))
			return dp[i][j] = 0 + editDistanceUtil(S1, S2, i - 1, j - 1, dp);

		// Minimum of three choices
		else
			return dp[i][j] = 1 + Math.min(editDistanceUtil(S1, S2, i - 1, j - 1, dp),
					Math.min(editDistanceUtil(S1, S2, i - 1, j, dp), editDistanceUtil(S1, S2, i, j - 1, dp)));

	}

}
