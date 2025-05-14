package viveksingh;

import java.util.Arrays;

public class SuffixMultiplication {


    public static void main(String[] args) {
        //right to left
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int len = arr.length;

        int[] suffixSum = new int[len];
        suffixSum[len-1] = arr[len-1];

        for (int i = len-2; i >=0; i--) {
            suffixSum[i] = suffixSum[i + 1] * arr[i];
        }


        System.out.println(Arrays.toString(suffixSum));
    }

}
