package arrays;

public class MaxWaterContainer {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {

        int result = Integer.MIN_VALUE;
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];

        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }

        maxRight[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        for (int i = 1; i < len - 1; i++) {
            int minOf2 = Math.min(maxLeft[i - 1], maxRight[i + 1]);
            if (minOf2 > height[i]) {
                result += minOf2 - height[i];
            }
        }
        return result;
    }

}

