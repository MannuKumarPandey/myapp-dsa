package priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DeleteGreatestValueInEachRow {


    public static void main(String[] args) {
        System.out.println(deleteGreatestValue(new int[][]{{1,2,4},{3,3,1}}));
    }


    public static int deleteGreatestValue(int[][] grid) {
        int result = 0;
        List<PriorityQueue<Integer>> listOfMaxHeaps = new ArrayList<>();

        for(int i = 0; i< grid.length; i++){
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            for(int j = 0; j<grid[i].length; j++){
                maxHeap.add(grid[i][j]);
            }
            listOfMaxHeaps.add(maxHeap);
        }

        while(listOfMaxHeaps.get(0).size() > 0){
            int localMax = Integer.MIN_VALUE;
            for(int p = 0; p<listOfMaxHeaps.size(); p++){
                localMax = Math.max(localMax, listOfMaxHeaps.get(p).poll());
            }
            result += localMax;
        }

        return result;
    }

}
