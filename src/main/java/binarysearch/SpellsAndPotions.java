package binarysearch;

import java.util.Arrays;

public class SpellsAndPotions {


    public static void main(String[] args) {
        int[] arr = successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7);
        for (int h : arr) {
            System.out.print(h + " ");
        }
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int left = 0;
            int right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long product = (long) spell * potions[mid];
                if (product >= success) {
                    pairs[i] = potions.length - mid;
                }

                if (product >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return pairs;
    }

}
