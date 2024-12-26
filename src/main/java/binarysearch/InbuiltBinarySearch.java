package binarysearch;

import java.util.Arrays;

public class InbuiltBinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3,4,5,6,7,8,9,10};
        int key = 9;
        int index1 = Arrays.binarySearch(arr, key);
        System.out.println(index1);

        int index2 = Arrays.binarySearch(arr,0,arr.length, key);
        System.out.println(index2);

    }
}
