package math;

public class TrailingZeroinAfactorial {
    public static void main(String[] args) {
        int num = 1;

        int result = 0;

        for (int i = 5; i <= num; i *= 5) {
            result = result + (num/i);
        }
        System.out.println(result);
    }
}