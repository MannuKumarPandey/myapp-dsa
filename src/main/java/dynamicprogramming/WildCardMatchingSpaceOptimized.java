package dynamicprogramming;

public class WildCardMatchingSpaceOptimized {

	public static void main(String args[]) {

		String S1 = "ab*cd";
		String S2 = "abdefcd";

		if (wildcardMatching(S1, S2))
			System.out.println("String S1 and S2 do match");
		else
			System.out.println("String S1 and S2 do not match");
	}

	static boolean isAllStars(String S1, int i) {

		// S1 is taken in 1-based indexing
		for (int j = 1; j <= i; j++) {
			if (S1.charAt(j - 1) != '*')
				return false;
		}
		return true;
	}

	static boolean wildcardMatching(String S1, String S2) {

		int n = S1.length();
		int m = S2.length();

		boolean prev[] = new boolean[m + 1];
		boolean cur[] = new boolean[m + 1];

		prev[0] = true;

		for (int i = 1; i <= n; i++) {
			cur[0] = isAllStars(S1, i);
			for (int j = 1; j <= m; j++) {

				if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?')
					cur[j] = prev[j - 1];

				else {
					if (S1.charAt(i - 1) == '*')
						cur[j] = prev[j] || cur[j - 1];

					else
						cur[j] = false;
				}
			}
			prev = (boolean[]) cur.clone();
		}

		return prev[m];

	}
}
