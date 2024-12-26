package sorting;

public class StringNumMaxOdd {

    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
    }

    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int f = num.charAt(i) - '0';
            if (f % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
