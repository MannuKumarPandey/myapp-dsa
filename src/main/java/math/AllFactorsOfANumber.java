package math;

import java.util.ArrayList;

public class AllFactorsOfANumber {

// 1st Way : Brute force
    /*
     * public static void main(String[] args) { int target = 18; ArrayList<Integer>
     * arrList = new ArrayList<Integer>();
     *
     * for (int i = 1; i <= target; i++) {
     *
     * if (target % i == 0) { arrList.add(i); } }
     * System.out.println(arrList.toString());
     *
     * }
     */

    public static void main(String[] args) {
        int target = 25;
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        for (int i = 1; i <= Math.sqrt(target); i++) {

            if (target % i == 0) {
                if (i == (target / i)) {
                    arrList.add(i);
                } else {
                    arrList.add(i);
                    arrList.add(target / i);
                }
            }
        }
        System.out.println(arrList.toString());

    }

}
