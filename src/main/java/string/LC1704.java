package string;

public class LC1704 {

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
    }

    public static boolean halvesAreAlike(String s) {
        int len = s.length();
        int mid = len / 2;
        return vowelCount(s.substring(0, mid)) == vowelCount(s.substring(mid, len));
    }


    public static int vowelCount(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U' ||
                    s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                result++;
            }
        }
        return result;
    }
}
