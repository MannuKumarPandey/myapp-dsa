package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {15, 18}, {8, 10}};
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        intervals = merge(intervals);
        for (int[] k : intervals) {
            System.out.println(Arrays.toString(k));
        }
    }

    public static int[][] merge(int[][] intervals) {
        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        ArrayList<int[]> list = new ArrayList<int[]>();
        // [[1, 3], [2, 6], [8, 10], [15, 18]]
        int rowL = intervals.length;
        int colL = intervals[0].length;

        int[] curPair = new int[2];
        curPair[0] = intervals[0][0];
        curPair[1] = intervals[0][1];

        for (int[] curInterval : intervals) {
            if (curPair[1] > curInterval[0]) {
                curPair[1] = Math.max(curPair[1], curInterval[1]);
            } else {
                list.add(Arrays.copyOf(curPair, curPair.length));
                curPair[0] = curInterval[0];
                curPair[1] = curInterval[1];
            }
        }
        list.add(Arrays.copyOf(curPair, curPair.length));
        int[][] res = new int[list.size()][colL];
        int m = 0;
        for (int[] kk : list) {
            res[m] = Arrays.copyOf(kk, kk.length);
            m++;
        }
        return res;
    }
}

