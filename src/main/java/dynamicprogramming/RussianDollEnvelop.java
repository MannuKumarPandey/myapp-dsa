package dynamicprogramming;

import java.util.Arrays;

public class RussianDollEnvelop {

    public static void main(String[] args) {
        //0th index is having width
        //1st index is having height

        int[][] envelopes = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(envelopes));

    }

    public static int maxEnvelopes(int[][] envelopes) {
        // Step 1: Sort envelopes
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Descending order for heights if widths are the same
            }
            return a[0] - b[0]; // Ascending order for widths
        });

        //sort ke bad envelopes: [[2,3], [5,4], [6,7], [6,4]]

        // Step 2: Extract the heights and find LIS
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        //yha heights[] = [3,4,7,4]

        return lengthOfLIS(heights);
    }

    private static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 0;

        for (int num : nums) {

            int index = Arrays.binarySearch(dp, 0, result, num);

            if (index < 0) {
                index = -(index + 1);
            }

            dp[index] = num;

            if (index == result) {
                result++;
            }
        }

        return result;
    }
}
