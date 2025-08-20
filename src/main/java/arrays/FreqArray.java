package arrays;

import java.util.Arrays;

public class FreqArray {

    public static void main(String[] args) {
        int[] arr = {2,1,3,4,5,2,3,4,5,6,7,8,9,5,4,5,6,7,3};


        // 0 to 9: using freq array
        int[] freq = new int[10];
        for(int a: arr){
            freq[a]++;
        }
        System.out.println(Arrays.toString(freq));


    }
}
