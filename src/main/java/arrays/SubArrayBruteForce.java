package arrays;

import java.util.ArrayList;
import java.util.List;

public class SubArrayBruteForce {

    public static void main(String[] args) {
        int[] arrr = {1, 2, 3};

        List<List<Integer>> allSubA = new ArrayList<>();

        for (int i = 0; i < arrr.length; i++) {
            for (int j = i; j < arrr.length; j++) {
                List<Integer> tempRes = new ArrayList<>();
                for(int k=i; k<=j; k++){
                    tempRes.add(arrr[k]);
                }
                allSubA.add(tempRes);
            }
        }
        System.out.println(allSubA);
    }
}
