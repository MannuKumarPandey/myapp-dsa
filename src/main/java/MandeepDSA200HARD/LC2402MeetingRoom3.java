package MandeepDSA200HARD;

import java.util.Arrays;

class LC2402MeetingRoom3 {

    public static void main(String[] args) {
        System.out.println(mostBooked(2, new int[][]{{0,10},{1,5},{2,7},{3,4}}));
    }

    public static int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0])); // Sort meetings by start time
        long[] endTimes = new long[n]; // When each room will be free
        long[] count = new long[n]; // Count of meetings in each room

        for (int[] meeting : meetings) {
            long start = meeting[0], end = meeting[1];
            boolean assigned = false;

            // Try to assign a free room
            for (int i = 0; i < n; i++) {
                if (endTimes[i] <= start) { // Room is free
                    endTimes[i] = end;
                    count[i]++;
                    assigned = true;
                    break;
                }
            }

            // If no free room, wait for the earliest one
            if (!assigned) {
                int earliestRoom = 0;
                for (int i = 1; i < n; i++) {
                    if (endTimes[i] < endTimes[earliestRoom]) {
                        earliestRoom = i;
                    }
                }
                endTimes[earliestRoom] += (end - start); // Delay meeting
                count[earliestRoom]++;
            }
        }

        // Find the room with the highest count of meeting helpd in that
        //in case of conducted same number of meetings in multiple rooms , return first smallest number of
        long maxMeetings = 0, bestRoom = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxMeetings || (count[i] == maxMeetings && i < bestRoom)) {
                maxMeetings = count[i];
                bestRoom = i;
            }
        }
        return (int) bestRoom;
    }
}