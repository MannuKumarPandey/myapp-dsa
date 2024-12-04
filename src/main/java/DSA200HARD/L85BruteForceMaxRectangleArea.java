package DSA200HARD;

public class L85BruteForceMaxRectangleArea {


    public static void main(String[] args) {
        // It is very similar question that max rectangle histogram problem
        System.out.println(MaxRectangleHistogramBruteForce(new int[][]{{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}}));
    }

    public static int MaxRectangleHistogramBruteForce(int[][] arr1) {
        int[] arr = new int[arr1[0].length];

        for(int i = 0; i<arr1[0].length; i++){
            int sum = 0;
            for (int[] ints : arr1) {
                sum += ints[i];
            }
            arr[i] = sum;
        }



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
