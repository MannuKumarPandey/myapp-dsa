package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Divisorsof3 {

    public static void main(String[] args) {

        int arr[] = new int[]{5, 12};
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            sieve(arr[i]);

        }
    }

    public static ArrayList<Integer> sieve(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        // Sieve Approach:
        int sieveArray[] = new int[n];
        Arrays.fill(sieveArray, 1);
        sieveArray[0] = 0;
        sieveArray[1] = 0;
        sieveArray[2] = 1;

        for (int i = 2; i * i <= n; i = i + 1) {
            if (sieveArray[i] == 1) {
                for (int k = i * i; k < n; k = k + i) {
                    sieveArray[k] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (sieveArray[i] == 1) {
                result.add(i);
            }
        }
        return result;

    }

}

