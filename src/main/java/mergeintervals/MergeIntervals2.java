package mergeintervals;

import java.util.Arrays;

/* Given an array of meeting time intervals consisting of start and end times
[[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required. */

public class MergeIntervals2 {

    public static void main(String[] args) {

        System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    }

    public static int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) return 0;

        int n = intervals.length;
        int index = 0;
        int begins[] = new int[n];
        int end[] = new int[n];
        for (int item[] : intervals) {
            begins[index] = item[0];
            end[index] = item[1];

            index += 1;
        }
        Arrays.sort(begins);
        Arrays.sort(end);
        int rooms = 0;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            rooms += 1;
            if (begins[i] >= end[pre]) {
                rooms -= 1;
                pre += 1;
            }
        }
        return rooms;
    }
}
