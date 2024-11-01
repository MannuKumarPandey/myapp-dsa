package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartitioning {
	public static void main(String[] args) {
		String s = "aabb";
		List<List<String>> res = palindromePartitioning(s);
		for (List<String> d : res) {
			for (String j : d) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	private static List<List<String>> palindromePartitioning(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> path = new ArrayList<String>();
		func(0, s, path, res);
		return res;

	}

	private static void func(int index, String s, List<String> path, List<List<String>> res) {
		if (index == s.length()) {
			res.add(new ArrayList<>(path));
			return;
		}

		// trying to partition from index 0 to last length of the string s
		for (int i = index; i < s.length(); ++i) {
			if (isPalindrome(s, index, i)) {
				path.add(s.substring(index, i + 1));
				func(i + 1, s, path, res);
				// BackTracking removal from path
				path.remove(path.size() - 1);
			}
		}

	}

	private static boolean isPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

}
