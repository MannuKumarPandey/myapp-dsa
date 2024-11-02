package string;

public class RemoveTrailingZero {

    public static void main(String[] args) {

        System.out.println(removeTrailingZeros("51230100"));


    }

    public static String removeTrailingZeros(String num) {
        int lastIndex = num.length();

        int i = lastIndex - 1;
        while (i >= 0) {
            if (num.charAt(i) == '0') {
                i--;
            } else {
                break;
            }
        }
        return num.substring(0, i + 1);
    }
}

