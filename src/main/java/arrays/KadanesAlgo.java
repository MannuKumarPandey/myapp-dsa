package arrays;

public class KadanesAlgo {
    public static void main(String[] args) {
        // Kadanes Algorithm
        int[] arr = new int[]{5, 4, -2, -7, 8};
        int len = arr.length;
        int resMax = Integer.MIN_VALUE;

        int localMax = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            localMax = Math.max(arr[i], arr[i] + localMax);
            resMax = Math.max(localMax, resMax);

        }

        System.out.println(resMax);
    }
}
