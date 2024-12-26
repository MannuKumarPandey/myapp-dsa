package math;

public class FactorialOfANumber {
    public static void main(String[] args) {
        int num = 6;
        System.out.println(factorial(num));

    }

    public static int factorial(int h) {
        if (h == 0 || h == 1) {
            return h;
        }

        return h * factorial(h - 1);
    }
}
