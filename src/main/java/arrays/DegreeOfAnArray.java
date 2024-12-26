package arrays;

public class DegreeOfAnArray {
    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }

    public static int findShortestSubArray(int[] nums) {
        int[] freq = new int[50000];

        for (int k : nums) {
            freq[k] = freq[k] + 1;
        }

        int max = Integer.MIN_VALUE;
        for (int k = 0; k < freq.length; k++) {
            if (freq[k] > max) {
                max = freq[k];
            }
        }
        return max;
    }
}
