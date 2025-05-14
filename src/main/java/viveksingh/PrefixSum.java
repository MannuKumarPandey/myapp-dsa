package viveksingh;

import java.util.Arrays;

public class PrefixSum {
    //left to right
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int len = arr.length;

        int []prefixSum = new int[len];
        prefixSum[0] = arr[0];

        for(int i=1; i<len; i++){
            prefixSum[i] = prefixSum[i-1]+arr[i];
        }


        System.out.println(Arrays.toString(prefixSum));
    }
}
