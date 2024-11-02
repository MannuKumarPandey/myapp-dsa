package math;

public class GCDOfTwoNumber {
    public static void main(String[] args) {
        int a = 45;
        int b = 12;

        System.out.println(GCD(a, b));
    }

    // Eculedian Algorithm to subtract the a from b and continues till b because 0
    public static int GCD(int a, int b) {
        if (b % a == 0) {
            return a;
        }

        return GCD(b % a, a);
    }

}
