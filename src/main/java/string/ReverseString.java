package string;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseStr("ba", 1));
    }

    public static String reverseStr(String s, int k) {

        String result = s;

        int length = s.length();

        for (int start = 0; start + 2 * k - 1 <= length; start = start + 2 * k) {
            result = reverse(result, start, start + k);
        }

        return result;

    }

    public static String reverse(String s, int start, int end) {
        char[] arr = s.toCharArray();

        int i = start;
        int j = end - 1;
        while (i <= j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}
