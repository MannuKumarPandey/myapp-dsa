package sorting;

import java.util.Arrays;

public class RelativeSortArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }


    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length];

        int[] freq = new int[1001];
        for (int h : arr1) {
            freq[h]++;
        }

        int i = 0;
        for (int p = 0; p < arr2.length; p++) {
            int freqD = freq[arr2[p]];
            int data = arr2[p];
            while (freqD-- > 0) {
                result[i++] = arr2[p];
                freq[arr2[p]]--;
            }
        }

        for (int k = 0; k < 1001; k++) {
            if (freq[k] != 0) {
                int freqD = freq[k];
                while (freqD-- > 0) {
                    result[i++] = k;
                    freq[k]--;
                }
            }
        }
        return result;
    }

}
