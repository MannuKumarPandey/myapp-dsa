package DSA200HARD;

import java.util.Stack;

public class L84OptimmizedLargestRectangleHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{2, 4}));
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
