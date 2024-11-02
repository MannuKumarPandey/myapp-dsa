package slidingwindow;

import java.util.HashSet;

public class MaxWindowSizeHavingMostUniqueElements {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 5, 6, 7, 8, 9, 1, 3, 1, 2, 1, 4};

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            HashSet<Integer> tempHash = new HashSet<Integer>();
            int j = i;

            while (j < arr.length && !tempHash.contains(arr[j])) {
                tempHash.add(arr[j]);
                j++;
            }

            result = Math.max(result, tempHash.size());
            i = j;
        }

        System.out.println(result);
    }

}

