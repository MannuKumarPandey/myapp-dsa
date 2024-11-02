package arrays;

public class TrappingRainWater {

    public static void main(String[] args) {

        int array[] = new int[]{4, 2, 0, 3, 2, 5};
        int length = array.length;
        int leftArray[] = new int[array.length];
        int rightArray[] = new int[array.length];

        leftArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            leftArray[i] = Math.max(leftArray[i - 1], array[i]);
        }

        rightArray[length - 1] = array[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightArray[i] = Math.max(rightArray[i + 1], array[i]);
        }

        int sum = 0;
        for (int i = 1; i < length - 1; i++) {
            sum = sum + Math.min(leftArray[i], rightArray[i]) - array[i];
        }
        System.out.println(sum);
    }

    //second way just a use ofm single loop
    public static int trap(int[] height) {
        int i = 0;
        int n = height.length - 1;
        int res = 0;
        int lMaxi = Integer.MIN_VALUE;
        int rMaxi = Integer.MIN_VALUE;
        while (i < n) {
            lMaxi = Math.max(lMaxi, height[i]);
            rMaxi = Math.max(rMaxi, height[n]);
            if (lMaxi <= rMaxi) {
                res += (lMaxi - height[i]);
                i += 1;
            } else if (rMaxi <= lMaxi) {
                res += (rMaxi - height[n]);
                n -= 1;
            }
        }
        return res;
    }
}
