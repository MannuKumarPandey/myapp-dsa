package math;

import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEranthoses {

    // Pre computation of Prime Numbers

    // Brute Force Approach
    public static void main(String[] args) {
        int n = 27;
        ArrayList<Integer> allPermutations = new ArrayList<Integer>();
        for (int i = 2; i < n; i++) {
            if (primeOrNot(i)) {
                allPermutations.add(i);
            }
        }
        System.out.println(allPermutations.toString());

        System.out.println("==============Sieve Coming =====================");
        System.out.println(sieve(27));

    }

    private static boolean primeOrNot(int i) {
        int sqrt = (int) Math.sqrt(i);
        for (int j = 2; j <= sqrt; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> sieve(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        //Sieve Approach:
        int sieveArray[] = new int[n];
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
}

