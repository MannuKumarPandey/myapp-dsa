package viveksingh;

import java.util.Arrays;

public class ReverseAnArrayUsingFunctionCall {

    public static void main(String[] args) {
        //T.C: O(n/2)=== O(n)
        //S.C: O(1)
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] res = reverseAnArray(arr,0,5);
        System.out.println(Arrays.toString(res));
    }

    public static int[] reverseAnArray(int[]arr, int startIndex, int endIndex){
        int len = arr.length;//1 unit
        int p1=startIndex;//1 unit
        int p2 = endIndex;//1 unit
        System.out.println(Arrays.toString(arr));
        while(p1<p2){
            int leftValue = arr[p1];
            arr[p1]= arr[p2];
            arr[p2]= leftValue;
            p1++;
            p2--;
        }
        return arr;
    }
}
