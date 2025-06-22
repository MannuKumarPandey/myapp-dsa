package viveksingh;

import java.util.Arrays;

public class ArrayCopyTest {


    public static void main(String[] args) {
        int[] arr1 = {2,3,4,5,1,8,7,6,9};
        System.out.println(Arrays.toString(arr1));
       // int []arr2 = arr1;
        int []arr3= new int[arr1.length];
        for(int i=0; i<arr1.length;i++){
            arr3[i]=arr1[i];
        }

      //  System.out.println(Arrays.toString(arr2));

        System.out.println("===========================");
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr3));
    }
}
