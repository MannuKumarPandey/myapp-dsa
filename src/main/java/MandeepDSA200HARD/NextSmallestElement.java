package MandeepDSA200HARD;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 45, 6, 7, 8, 1, 9};

        int[] nextSmallestElement = new int[arr.length];

        Stack<Integer> stack = new Stack<>(); //Stack me har respective smallervalues ka index rakhte jayenge
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nextSmallestElement[i] = arr.length;
            } else {
                nextSmallestElement[i] = stack.peek();
            }
            stack.push(i);
        }

        System.out.println("Original Array : " + Arrays.toString(arr));
        System.out.println("NSE Array : " + Arrays.toString(nextSmallestElement));// ye sabka indexes rakha hua hai aur wo index excluded nature me hai
    }
}
