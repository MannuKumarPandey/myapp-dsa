package arrays;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(7));
    }

    public static int fib(int num) {
        if (num == 1 || num == 0) {
            return num;
        }
        return fib(num - 1) + fib(num - 2);
    }
}
