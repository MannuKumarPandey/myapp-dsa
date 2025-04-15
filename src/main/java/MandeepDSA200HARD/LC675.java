package MandeepDSA200HARD;

import java.util.HashMap;

public class LC675 {
    static HashMap<Integer,Integer> hm = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(minSwapsCouples(new int[]{5,3,4,2,1,0}));
    }


    public static int minSwapsCouples(int[] row) {
        for (int i = 0; i < row.length; i++) {
            hm.put(row[i], i);
        }

        int swaps = 0;
        for (int i = 0; i < row.length; i += 2) {
            int firstPerson = row[i];
            int secondPerson = firstPerson ^ 1;

            if (row[i + 1] != secondPerson) {
                swaps++;
                swap(row, i + 1, hm.get(secondPerson));
            }
        }
        return swaps;
    }

    private static void swap(int[] row, int i, int j) {

        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;

        hm.put(row[i], i);
        hm.put(row[j], j);
    }
}
