package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversalOfAGraphLevelWiseControl {

    public static void main(String[] args) {
        System.out.println(bfsTraversal(3, new int[][]{{1, 0}, {1, 2}, {1, 3}}, 1).toString());
    }

    public static ArrayList<ArrayList<Integer>> bfsTraversal(int n, int[][] edges, int source) {
        ArrayList<ArrayList<Integer>> bfsTraversalList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjList = buildUnDirectedGraph(n, edges);
        boolean[] visitedArray = new boolean[n + 1];
        Arrays.fill(visitedArray, false);

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                ArrayList<Integer> bfsTraversalListLocal = new ArrayList<Integer>();
                int listC = queue.poll();
                if (!visitedArray[listC]) {
                    visitedArray[listC] = true;
                    bfsTraversalListLocal.add(listC);
                }
                ArrayList<Integer> childrens = adjList.get(listC);
                for (int j = 0; j < childrens.size(); j++) {
                    if (!visitedArray[childrens.get(j)]) {
                        queue.offer(childrens.get(j));
                    }
                }
                bfsTraversalList.add(bfsTraversalListLocal);
            }

        }
        return bfsTraversalList;
    }

    public static ArrayList<ArrayList<Integer>> buildUnDirectedGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        return adjList;
    }

}

