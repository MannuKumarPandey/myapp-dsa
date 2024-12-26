package priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KWeakestRowsInMatrix {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(kWeakestRows(
                new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
                }, 3)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];

        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>();
        for (int i = 0; i < mat.length; i++) {
            int noOfOnes = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    noOfOnes++;
                }
            }
            minHeap.add(new Pair(noOfOnes, i));
        }
        int p = 0;
        while (k-- > 0) {
            Pair curPair = minHeap.poll();
            result[p++] = curPair.index;
        }

        return result;


    }

    public static class Pair implements Comparable<Pair> {
        int noOfOnes;
        int index;

        Pair(int noOfOnes, int index) {
            this.noOfOnes = noOfOnes;
            this.index = index;
        }

        @Override
        public int compareTo(Pair that) {
            return this.noOfOnes - that.noOfOnes;
        }
    }
}
