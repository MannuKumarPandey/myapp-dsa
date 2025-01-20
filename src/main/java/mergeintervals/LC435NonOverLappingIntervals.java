package mergeintervals;

import java.util.Arrays;
import java.util.Stack;

public class LC435NonOverLappingIntervals {

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1]-b[1]);
        int n = intervals.length;
        int prev = 0;
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                cnt++;
            }
        }

        return n - cnt;

    }

}
