package arrays;

import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        int arr[] = decimalToBinary(8);
        for (int k : arr) {
            System.out.print(k + " ");
        }
    }

    public static int[] decimalToBinary(int n) {
        Stack<Integer> stack = new Stack<Integer>();

        while (n > 0) {
            int rem = n % 2;
            n = n / 2;
            stack.push(rem);
        }
        int result[] = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }

        return result;
    }

}
