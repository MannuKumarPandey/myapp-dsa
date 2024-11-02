package slidingwindow;

import java.util.HashSet;

public class MaxWindoSizeMaxMultiplicationsInIntArray {

    public static void main(String[] args) {

        int[] arr = new int[]{-1, 2, 5, -6, 7, 8, -9, 1, 3, -1, 2, 1, 4};

        // Elements duplicates ho sakte hai
        // Max multiplication ka max size kitna hai
        //Thora modification is required

        int result = Integer.MIN_VALUE;
        int finalMultiplications = 1;
        HashSet<Integer> tempHashR = null;
        for (int i = 0; i < arr.length; i++) {

            HashSet<Integer> tempHash = new HashSet<Integer>();
            int tempMultiplications = 1;

            int j = i;

            while (j < arr.length && !tempHash.contains(arr[j])) {
                tempMultiplications *= arr[j];
                tempHash.add(arr[j]);
                j++;
            }

            if (tempMultiplications > finalMultiplications) {
                result = Math.max(result, tempHash.size());
                finalMultiplications = Math.max(tempMultiplications, finalMultiplications);
                tempHashR = new HashSet<Integer>(tempHash);
            }
            i = j;
        }

        System.out.println(result);
        System.out.println(finalMultiplications);
        System.out.println("========");
        for (int k : tempHashR) {
            System.out.print(k + " ");
        }
    }

}

