package Dhruveel;

public class MaxWindowSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, -1, 2, -4, 5, 2, 4}; // 11
        int k = 3;
        int len = arr.length;
        int result = Integer.MIN_VALUE; //-2147483648

        int currentWS = 0;

        for (int i = 0; i < k; i++) {
            currentWS += arr[i];      //6
        }

        result = Math.max(result, currentWS);

        for (int i = k; i < len; i++) {
            currentWS = currentWS + arr[i] - arr[i - k];
            result = Math.max(result, currentWS);
        }

        System.out.println(result);//O(2*n) ==== O(n)
    }
}
