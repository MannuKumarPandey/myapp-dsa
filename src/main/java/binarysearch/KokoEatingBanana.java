package binarysearch;

public class KokoEatingBanana {

    public static void main(String[] args) {
        System.out.println(bs(new int[]{3, 6, 7, 11}, 0, 4, 8));
    }

    private static int bs(int[] piles, int left, int right, int h) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (computeTime(piles, mid) <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static long computeTime(int[] piles, int k) {
        long res = 0;
        for (int pile : piles)
            res += ((pile + k - 1) / k);
        return res;
    }
}
