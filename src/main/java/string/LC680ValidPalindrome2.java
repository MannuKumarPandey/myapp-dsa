package string;

public class LC680ValidPalindrome2 {


    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            //at any index if characters are not matching then
            //check for both parts if they are palindome seprately
            //even if any off the string is palindrome then they can be palindrome
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) ||
                        isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
