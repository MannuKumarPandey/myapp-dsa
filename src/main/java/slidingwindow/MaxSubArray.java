package slidingwindow;

public class MaxSubArray {

    //kadane's Algorithm

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    public static int maxSubArray(int[] nums) {
        int currSum = Integer.MIN_VALUE;
        int arrLen = nums.length;
        int i = 0;
        int localSum = 0;
        while (i < arrLen) {

            if (localSum + nums[i] < 0) {
                localSum = 0;
                i++;

            } else {
                localSum = localSum + nums[i];
                currSum = Math.max(currSum, localSum);
                i++;
            }


        }

        return currSum;

    }

}

