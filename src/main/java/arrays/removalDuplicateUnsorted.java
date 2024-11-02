package arrays;

import java.util.Arrays;

public class removalDuplicateUnsorted {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 22, 23, 11, 1, 2, 33, 23};

        Arrays.sort(arr);// 1 1 2 2 3 4 11 22 23 23 33

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                arr[i] = -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                System.out.print(arr[i] + " ");
            }
        }
    }

}
