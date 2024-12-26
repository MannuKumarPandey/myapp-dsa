package math;


import java.util.ArrayList;
import java.util.Arrays;

public class AllNoOfPrimeFactors {

    public static void main(String[] args) {
        //One approach is just get the max of the query and create sieve array for that and then calculate for that


        int[] query = new int[]{3, 5, 6, 7, 36, 25};
        int[] result = new int[query.length];
        for (int i = 0; i < result.length; i++) {
            ArrayList<Integer> resultTemp = sieve(query[i]);
            result[i] = resultTemp.size();
        }

        for (int k : result) {
            System.out.print(k + " ");
        }
    }

    // Dont use sieve here : We need to gewt the all factors of query value and then
    // check for prime numebrs
    public static ArrayList<Integer> sieve(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        // Sieve Approach:
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

