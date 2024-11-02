package mergeintervals;

import java.util.Arrays;

public class MinNoOfMeetingRooms {

    public static void main(String[] args) {
        System.out.println(minNoOfMeetingRooms(new int[][]{{0, 5}, {1, 2}, {6, 10}}));
    }

    public static int minNoOfMeetingRooms(int[][] intervals) {

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        // [[1, 3], [2, 6], [8, 10], [15, 18]]

        int[] curPair = new int[2];
        curPair[0] = intervals[0][0];
        curPair[1] = intervals[0][1];
        int count = 0;

        for (int[] curInterval : intervals) {
            if (curPair[1] >= curInterval[0]) {
                count++;
            } else {
                curPair[0] = curInterval[0];
                curPair[1] = curInterval[1];
            }
        }
        return count;
    }

}

