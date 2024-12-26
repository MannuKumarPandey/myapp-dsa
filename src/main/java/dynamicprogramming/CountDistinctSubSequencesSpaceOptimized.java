package dynamicprogramming;

public class CountDistinctSubSequencesSpaceOptimized {

	static int prime = (int) (Math.pow(10, 9) + 7);

	public static void main(String args[]) {

		String s1 = "babgbag";
		String s2 = "bag";

		System.out.println(
				"The Count of Distinct Subsequences is " + subsequenceCounting(s1, s2, s1.length(), s2.length()));
	}

	static int subsequenceCounting(String s1, String s2, int n, int m) {
		// Write your code here.

		int[] prev = new int[m + 1];
		prev[0] = 1;

		for (int i = 1; i < n + 1; i++) {
			for (int j = m; j >= 1; j--) { // Reverse direction

				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					prev[j] = (prev[j - 1] + prev[j]) % prime;
				else
					prev[j] = prev[j]; // can omit this statemwnt
			}
		}

		return prev[m];
	}
}
