package DSA200HARD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class L218SkyLineProblem {
    public static void main(String[] args) {
        System.out.println(getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}));
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {

        /*
         * Main aim yah hai ki har ek start and end point par sorted way me jo max
         * height hogi uspar travel karna hai
         */
        List<Pair> list = new ArrayList<Pair>();// Jo start point , end point and height ek sath diya hua hai usko
        // {startpoint, endpoint, height} = {{startpoint, height},{endpoint, height}}
        for (int i = 0; i < buildings.length; i++) {
            int startPoint = buildings[i][0];
            int endPoint = buildings[i][1];
            int height = buildings[i][2];
            Pair p1 = new Pair(startPoint, -height);// har bar start point ki height ko -1 se multiply karke store kar
            // rahe hai
            Pair p2 = new Pair(endPoint, height);// Jabki end point wali height ko as it is rakh rahe hai
            list.add(p1);
            list.add(p2);
        }
        Collections.sort(list);

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        // Jitani bhi active rectangles hai us points par uski height store karne ke
        // liye.

        int currentHeight = 0;
        maxHeap.add(0);

        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i).x;
            int ht = list.get(i).ht;

            if (ht < 0) { // meaning starting point hai
                maxHeap.add(-ht);// since while adding in list we had done *-1 so again do that.

            } else {// meaning ending point hai
                maxHeap.remove(ht);
            }

            if (currentHeight != maxHeap.peek()) {
                List<Integer> tempAns = new ArrayList<Integer>();
                tempAns.add(x);
                tempAns.add(maxHeap.peek());
                result.add(tempAns);
                currentHeight = maxHeap.peek();
            }

        }

        return result;

    }

    public static class Pair implements Comparable<Pair> {
        int x;
        int ht;

        public Pair(int x, int ht) {
            this.x = x;
            this.ht = ht;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return this.ht - o.ht;
            }
        }

    }
}
