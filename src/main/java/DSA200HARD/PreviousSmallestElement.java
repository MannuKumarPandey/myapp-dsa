package DSA200HARD;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallestElement {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 45, 6, 7, 8, 1, 9};

        int[] prevSmallestElement = new int[arr.length];

        Stack<Integer> stack = new Stack<>(); //Stack me har respective smallervalues ka index rakhte jayenge
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                prevSmallestElement[i] = 0;
            } else {
                prevSmallestElement[i] = stack.peek();
            }
            stack.push(i);
        }

        System.out.println("Original Array : " + Arrays.toString(arr));
        System.out.println("PSE Array : " + Arrays.toString(prevSmallestElement));// ye sabka indexes rakha hua hai aur wo index excluded nature me hai
    }

}
