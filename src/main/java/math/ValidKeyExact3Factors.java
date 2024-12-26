package math;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidKeyExact3Factors {

    // First Approach

    public static void main(String[] args) {
        int[] arr = new int[]{5, 11, 49};

        int[] result = new int[arr.length];

        // finding max value from array
        int max = Integer.MIN_VALUE;  // take contraints as 10 to the power 13
        for (int h : arr) {
            max = Math.max(max, h);
        }

        int[] preComputation = new int[max + 1];
        Arrays.fill(preComputation, 0);

        for (int i = 0; i < max + 1; i++) {
            if (isValid(i)) {
                preComputation[i] = 1;
            } else {
                preComputation[i] = 0;
            }
        }

        for (int i = 0; i < result.length; i++) {

            result[i] = fillData(preComputation, arr[i]);
        }
        for (int k : result) {
            System.out.print(k + " ");
        }
    }

    private static int fillData(int[] preComputation, int target) {

        int count = 0;
        for (int i = 0; i <= target; i++) {
            if (preComputation[i] == 1) {
                count++;
            }
        }
        return count;
    }

    private static boolean isValid(int p) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= Math.sqrt(p); i++) {
            if (p % i == 0) {
                if (i * i == p) {
                    list.add(i);
                } else {
                    list.add(i);
                    list.add(p / i);
                }
            }
        }

        return list.size() == 3;
    }

    // Second Approach
    // Prime number ka square nikale jo bhi prime number ke square numbers hai

}

