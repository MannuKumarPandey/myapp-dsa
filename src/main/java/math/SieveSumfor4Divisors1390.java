package math;

public class SieveSumfor4Divisors1390 {

    public static void main(String[] args) {
        System.out.println(sumFourDivisors(new int[] { 21, 4, 7 }));
    }

    public static int sumFourDivisors(int[] nums) {

        int result = 0;

        for (int h : nums) {
            result += hasFourDivisors(h);
        }
        return result;
    }

    public static int hasFourDivisors(int n) {
        int result = 0;
        int resultSum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                result++;
                resultSum += i;
            }
        }
        return result == 4 ? resultSum : 0;
    }
}
