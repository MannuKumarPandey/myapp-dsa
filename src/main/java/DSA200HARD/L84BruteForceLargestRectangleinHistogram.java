package DSA200HARD;

public class L84BruteForceLargestRectangleinHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleHistogramBruteForce(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleHistogramBruteForce(new int[]{2, 4}));
    }

    public static int largestRectangleHistogramBruteForce(int[] arr) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int leftSmaller = findLeftSmaller(arr, i);
            int rightSmaller = findRightSmaller(arr, i);
            int localArea = (rightSmaller - leftSmaller + 1) * arr[i];
            result = Math.max(result, localArea);
        }
        return result;
    }

    private static int findRightSmaller(int[] arr, int cur) {
        int smallerIndex = cur;
        if (cur == arr.length - 1) {
            return cur;
        }
        for (int i = cur + 1; i < arr.length; i++) {
            if (arr[i] >= arr[cur]) {
                smallerIndex = i;

            } else {
                break;
            }
        }
        return smallerIndex;
    }

    private static int findLeftSmaller(int[] arr, int cur) {
        int smallerIndex = cur;
        if (cur == 0) {
            return 0;
        }
        for (int i = cur - 1; i >= 0; i--) {
            if (arr[i] >= arr[cur]) {
                smallerIndex = i;
            } else {
                break;
            }
        }
        return smallerIndex;
    }
}
