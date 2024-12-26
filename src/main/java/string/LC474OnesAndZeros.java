package string;

public class LC474OnesAndZeros {


    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int result = 0;

        for (String s : strs) {
            if (isValid(s, m, n)) {
                result++;
            }
        }

        return result;
    }

    public static boolean isValid(String s, int m, int n) {
        int len = s.length();
        s = s.replace("0", "");
        int onesCount = s.length();
        int zerosCount = len - onesCount;
        return onesCount < n && zerosCount < m;
    }
}
