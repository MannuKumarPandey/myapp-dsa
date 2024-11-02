package arrays;

public class SubarraysSuminRangeatob {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 8, 7};

        int len = arr.length;

        int[][] query = new int[][]{{0, 5}, {2, 3}, {2, 5}};

        int[] result = new int[query.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = getRangeSum(len, arr, query[i][0], query[i][1]);
        }

        for (int k : result) {
            System.out.print(k + " ");

        }

    }

    public static int getRangeSum(int len, int[] arr, int left, int right) {
        int[] prefixSum = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                prefixSum[i] = arr[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + arr[i];
            }
        }

        if (left == 0) {
            return prefixSum[right];
        }

        return (prefixSum[right]) - (prefixSum[left - 1]);
    }

}

