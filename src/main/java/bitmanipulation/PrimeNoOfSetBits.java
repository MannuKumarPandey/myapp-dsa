package bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNoOfSetBits {

    public static void main(String[] args) {
        System.out.println(new PrimeNoOfSetBits().countPrimeSetBits(6, 10));
    }

    public static ArrayList<Integer> sieve(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        // Sieve Approach:
        int[] sieveArray = new int[n];
        Arrays.fill(sieveArray, 1);
        sieveArray[0] = 0;
        sieveArray[1] = 0;

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

    public static int getSetBits(int n) {
        int count = 0;

        for (int i = 0; i < 16; i++) {

            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        ArrayList<Integer> sieves = sieve(10001);
        for (int i = left; i <= right; i++) {
            int noOfSetBits = getSetBits(i);
            if (sieves.contains(noOfSetBits)) {
                result++;
            }
        }
        return result;
    }
}
