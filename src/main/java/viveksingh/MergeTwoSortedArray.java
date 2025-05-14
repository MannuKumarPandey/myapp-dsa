package viveksingh;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int arr1[] = {5, 10, 22, 30, 40};
        int arr2[] = {1, 9, 17, 34, 59};

        int i = 0;//arr1
        int len1 = arr1.length;
        int j = 0;//arr2
        int len2 = arr2.length;

        int[] result = new int[len1 + len2];
        int p = 0;//result

        while (i < len1 && j < len2) {
            if (arr1[i] > arr2[j]) {
                result[p] = arr2[j];
                p++;
                j++;
            } else {
                result[p] = arr1[i];
                p++;
                i++;
            }
        }

        while (i < len1) {
            result[p] = arr1[i];
            p++;
            i++;
        }

        while (j < len2) {
            result[p] = arr2[j];
            p++;
            j++;
        }

        System.out.println(Arrays.toString(result));
    }
}
