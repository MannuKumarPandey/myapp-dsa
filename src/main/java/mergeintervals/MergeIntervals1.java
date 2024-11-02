package mergeintervals;

/* Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals, and return an array of the
non-overlapping intervals that cover all the intervals in the input. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals1 {

    public static void main(String[] args) {
        int[][] res = new int[][]{{1, 3}, {2, 6}, {8, 1}, {15, 1}};
        res = merge(res);
        for (int[] arr : res) {
            for (int h : arr) {
                System.out.print(h + " ");
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) return intervals;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> res = new ArrayList<>();
        int curr[] = intervals[0];
        res.add(curr);
        // for(int i=1; i<intervals.length; i++)
        for (int item[] : intervals) {
            if (item[0] <= curr[1]) {
                curr[1] = Math.max(item[1], curr[1]);
            } else {
                curr = item;
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
