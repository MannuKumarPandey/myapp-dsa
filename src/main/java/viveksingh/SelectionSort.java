package viveksingh;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int []arr = {10,5,2,4,3,7,8,9,6,1};
        System.out.println(Arrays.toString(arr));

        ///selection sort
        //i is the outer pointer
        for(int i=0; i<arr.length; i++){
            int minIndex = i;
            int minValue = arr[i];

            //minimum ka selection
            for(int j=i; j<arr.length; j++){
                if (arr[j] < minValue) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }

            //swap i and minIndex
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
