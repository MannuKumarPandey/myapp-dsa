package bitmanipulation;


public class BitOperators {
    public static void main(String[] args) {
        /*
         * System.out.println(1 & 0); System.out.println(1 | 0);
         *
         * System.out.println(10 >> 2);
         */

        System.out.println(uniqueNumber(new int[]{2, 3, 2, 3, 4, 5, 6, 4, 5}));
    }

    //
    public static int uniqueNumber(int[] arr) {

        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = res ^ arr[i];
        }

        return res;
    }

}
