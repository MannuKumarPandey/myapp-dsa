package MandeepDSA200HARD;

import java.util.Arrays;

public class LC321CreateMaxNumber {

    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 4, 6, 5};
        int[] arr2 = new int[]{9, 1, 2, 5, 8, 3};
        int k = 5;
        System.out.println(Arrays.toString(maxNumber(arr1, arr2, k)));
    }

    private static int[] maxNumber(int[] arr1, int[] arr2, int k) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] result = new int[k];

        //arr1 se i element pahle select karo and then
        // k-i arr2 se select karo
        // k = 5 len2 = 6 k=len2 = -1
        for(int i = Math.max(k-len2, 0); i <= Math.min(len1, k); i++){
            int[] res1 = getMaxArrayUtil(arr1, i);
            int[] res2 = getMaxArrayUtil(arr2, k-i);

            int[] mergedArray = mergeArray(res1, res2);

            if(greater(mergedArray, 0, result, 0)){
                result = mergedArray;
            }
        }
        return result;
    }

    private static boolean greater(int[] mergedArray, int i, int[] result, int j) {
        //return ki pahle array jo function call me ayi hai wo badi hai ya nahi

        while(i<mergedArray.length && j < result.length && mergedArray[i] == result[j]){
            i++;
            j++;
        }

        //agar dono equal hui tb mai pahle ko bada batata hu

        return j == result.length || (i < mergedArray.length && mergedArray[i] > result[j]);

    }

    private static int[] mergeArray(int[] res1, int[] res2) {

        int len1 = res1.length;
        int len2 = res2.length;
        int[] mergedArray = new int[len1+len2];

        int res1p = 0;
        int res2p = 0;
        int res3p = 0;//mergedArray ko travel karenge


        while(res1p < len1 || res2p < len2){
            if(res1p < len1 && res2p < len2){
                //greater(res1, res2)  : kya res1 bada hai?
                if(greater(res1, res1p, res2, res2p)){
                    mergedArray[res3p] = res1[res1p];
                    res3p++;
                    res1p++;
                }else{
                    mergedArray[res3p] = res2[res2p];
                    res3p++;
                    res2p++;
                }
            }else if(res1p < len1){
                mergedArray[res3p] = res1[res1p];
                res3p++;
                res1p++;
            }else{
                mergedArray[res3p] = res2[res2p];
                res3p++;
                res2p++;
            }
        }

        return mergedArray;
    }

    private static int[] getMaxArrayUtil(int[] arr, int size) {
        int len = arr.length;
        int[] result = new int[size];
        int x = 0;//result ka pointer hai

        for(int i = 0; i<len; i++){
            while(x > 0 && result[x-1] < arr[i] && ((len-i) > (size-x))){
                x--;
            }
            if(x < size){
                result[x] = arr[i];
                x++;
            }
        }
        return result;
    }
}
