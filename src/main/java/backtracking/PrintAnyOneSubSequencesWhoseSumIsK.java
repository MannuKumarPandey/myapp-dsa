package backtracking;

import java.util.ArrayList;

public class PrintAnyOneSubSequencesWhoseSumIsK {

    static boolean flag = false;

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int[] arr = {3, 1, 2};
        int k = 3;
        printAnyOneSubSequenceEqualToK(0, arr, al, k);
    }

    private static void printAnyOneSubSequenceEqualToK(int i, int[] arr, ArrayList<Integer> al, int K) {

        if (i == arr.length) {
            int sum = 0;
            for (int h : al) {
                sum = sum + h;
            }
            if (sum == K && !flag) {
                for (int h : al) {
                    System.out.print(h + " ");
                }
                flag = true;
                System.out.println();
                return;
            }
            return;
        }
        al.add(arr[i]);
        printAnyOneSubSequenceEqualToK(i + 1, arr, al, K);
        // ek ek integer ko remove kar karke fir se newly take or not take kind of
        // case me badhate chale wo automatic sare sequences ko print kar dega.

        al.remove(Integer.valueOf(arr[i]));
        printAnyOneSubSequenceEqualToK(i + 1, arr, al, K);

    }

}
