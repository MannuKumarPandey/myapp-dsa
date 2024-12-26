package recursion;

public class StringPalindrome {
	public static void main(String[] args) {
		System.out.println(palindrome(0, 6, "FABCBAF"));
	}

	private static boolean palindrome(int startIndex, int endIndex, String string) {

		if (startIndex > endIndex) {
			return true;
		}
		return string.charAt(startIndex) == string.charAt(endIndex) && palindrome(startIndex + 1, endIndex - 1, string);
	}
}
