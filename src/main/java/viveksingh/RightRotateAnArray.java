package viveksingh;

import java.util.Arrays;

public class RightRotateAnArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int k = 4;
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        //step 1
        reverseAnArray(arr, n-k, n-1);
        reverseAnArray(arr, 0, n-k-1);
        reverseAnArray(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseAnArray(int[] arr, int startIndex, int endIndex){
        while(startIndex <= endIndex){
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] =  temp;
            startIndex++;
            endIndex--;
        }
    }
}
