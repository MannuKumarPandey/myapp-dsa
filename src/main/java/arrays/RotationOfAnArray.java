package arrays;

import java.util.Arrays;

public class RotationOfAnArray {

    public static void main(String[] args) {
        int []arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int k=3;
        System.out.println("Before swappig "+Arrays.toString(arr));

        //1st step: reverse 0 to k-1

        for(int i=0; i<k; i++){
            int temp= arr[i];
            arr[i] = arr[k-1-i];
            arr[k-1-i] = temp;
        }


        System.out.println(Arrays.toString(arr));
    }
}
