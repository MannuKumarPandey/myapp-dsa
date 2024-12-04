package DSA200HARD;

import java.util.Stack;

public class L85OptimizedMaxRectangleArea {

    public static void main(String[] args) {
        // It is very similar question that max rectangle histogram problem
        System.out.println(maxRectangleHistogram(new int[][]{{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}}));
    }

    private static int maxRectangleHistogram(int[][] arr1) {
        int[] arr = new int[arr1[0].length];
        for (int i = 0; i < arr1[0].length; i++) {
            int sum = 0;
            for (int[] ints : arr1) {
                sum += ints[i];
            }
            arr[i] = sum;
        }
        return largestRectangleArea(arr);
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextSmallestElement = new int[n]; // next smaller element: Matlab jis index par hai uske right side ka pahla smallest value ka index
        int[] previousSmallestElement = new int[n]; // previous smaller element : Matlab jis index par hai uske left side ka pahla smallest value

        Stack<Integer> stack = new Stack<>();

        // Compute NSE (Next Smaller Element) for each bar
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextSmallestElement[i] = n;
            } else {
                nextSmallestElement[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear(); // Clear stack for the next use

        // Compute PSE (Previous Smaller Element) for each bar
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                previousSmallestElement[i] = -1;
            } else {
                previousSmallestElement[i] = stack.peek();
            }
            stack.push(i);
        }

        int maxArea = 0;

        // Calculate the maximum area
        for (int i = 0; i < n; i++) {
            int width = nextSmallestElement[i] - previousSmallestElement[i] - 1;
            int area = heights[i] * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
