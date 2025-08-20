package arrays;

import java.util.Arrays;

public class CustomSort {

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3, 7};
        int len = arr.length;
        //Arrays.sort(arr);

        Integer[] modifiedWrapperInt = new Integer[len];
        for(int i=0; i<len; i++){
            modifiedWrapperInt[i]= Integer.valueOf(arr[i]);
        }
        int[] count = new int[201];
        for (int num : arr) {
            count[num + 100]++;
        }

        //here Arrays.sort is expecting Wrapper class object details not the premitive details
        Arrays.sort(modifiedWrapperInt, (a, b) -> {
            if (count[a + 100] == count[b + 100]) {//if freq of two elements a and b are same : return any of them first
                return a - b;
            }
            return count[a + 100] - count[b + 100];
            //if freq of both the elements are not same then return the elements in increasing order of their freq
        });
        System.out.println(Arrays.toString(modifiedWrapperInt));

    }

    //  System.out.println(Arrays.toString(arr));
    //premitive data type
        /*int a = 10;
        System.out.println(a);*/
    //Wrapper class
        /*Integer aa = Integer.valueOf(10);
        System.out.println(aa);*/

}
