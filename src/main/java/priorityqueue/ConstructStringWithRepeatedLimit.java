package priorityqueue;

import java.util.PriorityQueue;

public class ConstructStringWithRepeatedLimit {

    public static void main(String[] args) {
        System.out.println(repeatLimitedString("cczazcc", 3));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        //max heap on basis of character
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            char currChar = (char) ('a' + curr[0]);
            int count = Math.min(curr[1], repeatLimit);
            for (int i = 0; i < count; i++) {
                res.append(currChar);
            }
            curr[1] -= count;

            if (curr[1] > 0) {
                //matlab sirf wahi character bacha hua tha isliye ab unko ab eksath add nahi kar sakte hai
                if (maxHeap.isEmpty()) break;

                //next bada character pick karte hai
                int[] next = maxHeap.poll();
                char nextChar = (char) ('a' + next[0]);
                //aur isko sirf ekbar append karenge
                res.append(nextChar);
                next[1]--;

                if (next[1] > 0) {
                    maxHeap.offer(next);
                }
                maxHeap.offer(curr);
            }
        }
        return res.toString();
    }
}
