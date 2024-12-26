package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RowWithMaxOnes {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rowAndMaximumOnes(new int[][]{{0, 1}, {1, 0}})));
    }

    public static int[] rowAndMaximumOnes(int[][] mat) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>();
        for (int i = 0; i < mat.length; i++) {
            maxHeap.offer(countOnes(mat[i], i));
        }

        Pair firstP = maxHeap.poll();
        if (!maxHeap.isEmpty()) {
            Pair s = maxHeap.poll();
            if (s.noOfOne == firstP.noOfOne) {
                return new int[]{Math.min(s.rowIndex, firstP.rowIndex), Math.max(s.noOfOne, firstP.noOfOne)};
            } else {
                return new int[]{firstP.rowIndex, firstP.noOfOne};
            }
        } else {
            return new int[]{firstP.rowIndex, firstP.noOfOne};
        }

    }

    public static Pair countOnes(int[] arr, int row) {
        int count = 0;
        for (int a : arr) {
            if (a == 1) {
                count++;
            }
        }
        return new Pair(count, row);
    }

    public static class Pair implements Comparable<Pair> {
        int noOfOne;
        int rowIndex;

        Pair(int noOfOne, int rowIndex) {
            this.noOfOne = noOfOne;
            this.rowIndex = rowIndex;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.noOfOne == o.noOfOne) {
                return this.rowIndex - o.rowIndex;
            } else {
                return o.noOfOne - this.noOfOne;
            }
        }
    }
}
