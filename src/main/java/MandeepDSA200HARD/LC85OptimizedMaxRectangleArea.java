package MandeepDSA200HARD;

import java.util.Stack;

public class LC85OptimizedMaxRectangleArea {

    public static void main(String[] args) {
        // It is very similar question that max rectangle histogram problem
        System.out.println(maxRectangleHistogram(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println(maxRectangleHistogram(new char[][]{{'1', '0'}, {'0', '1'}}));
    }

    public static int maxRectangleHistogram(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns

        // Array to store the height of the histogram for each column
        int[] heights = new int[m];
        int maxArea = 0;

        // Traverse each row and calculate the maximal rectangle
        for (int i = 0; i < n; i++) {
            // Update the histogram heights based on the current row
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++; // Increase height if the cell contains '1'
                } else {
                    heights[j] = 0; // Reset height if the cell contains '0'
                }
            }

            // Find the maximal rectangle area for the current histogram (heights array)
            maxArea = Math.max(maxArea, largestRectangleInHistogram(heights));
        }

        return maxArea;
    }


    // Function to calculate the largest rectangle in a histogram
    private static int largestRectangleInHistogram(int[] heights) {
        int n = heights.length;

        // Arrays to store Previous Smaller Element (PSE) and Next Smaller Element (NSE)
        int[] pse = new int[n]; // Previous Smaller Element
        int[] nse = new int[n]; // Next Smaller Element

        // Stack to store indices for PSE calculation
        Stack<Integer> stack = new Stack<>();

        // Calculate Previous Smaller Element (PSE)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pse[i] = stack.peek();
            } else {
                pse[i] = -1;
            }
            stack.push(i);
        }

        // Clear the stack for NSE calculation
        stack.clear();

        // Calculate Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nse[i] = stack.peek();
            } else {
                nse[i] = n;
            }
            stack.push(i);
        }

        // Calculate the maximum area using PSE and NSE
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }

}
