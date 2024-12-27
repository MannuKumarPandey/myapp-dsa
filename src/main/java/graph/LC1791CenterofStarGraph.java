package graph;

import java.util.HashMap;
import java.util.Map;

public class LC1791CenterofStarGraph {


    public static void main(String[] args) {
        System.out.println(findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
    }

    public static int findCenter(int[][] edges) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int[] arr : edges) {
            hm.put(arr[0], hm.getOrDefault(arr[0], 0) + 1);
            hm.put(arr[1], hm.getOrDefault(arr[1], 0) + 1);
        }

        int centerNode = -1;
        for (Map.Entry<Integer, Integer> mm : hm.entrySet()) {
            if (mm.getValue() == edges.length) {
                centerNode = mm.getKey();
                break;
            }
        }
        return centerNode;
    }
}
