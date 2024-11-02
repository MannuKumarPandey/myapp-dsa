package arrays;

public class EvenNoLengthSubArraySum {

    public static void main(String[] args) {
        // 1st Approach
        int[] arr1 = new int[]{1, 4, 2, 5, 3};
        int len = arr1.length;
        int resMax = 0;
        int localSum = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if ((j - i + 1) % 2 == 0) {
                    localSum = 0;
                    for (int k = i; k < j + 1; k++) {
                        localSum += arr1[k];
                    }
                    resMax = resMax + localSum;
                }
            }
        }
        System.out.println("1st Approach Output: " + resMax);
        // ======================================================================
        // second approach : Pattern wise: like
        int[] arr = new int[]{1, 4, 2, 5, 3};
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            res += (((i + 1) * (n - i)) / 2) * arr[i];
        }
        System.out.println("Second Approach sum is ::::: " + res);
        // =========================================================================
    }
}
