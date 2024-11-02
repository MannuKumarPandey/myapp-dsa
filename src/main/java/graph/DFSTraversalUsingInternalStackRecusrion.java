package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DFSTraversalUsingInternalStackRecusrion {

    public static ArrayList<ArrayList<Integer>> adjList;
    public static ArrayList<Integer> dfsTraversalList;

    public static void main(String[] args) {

        dfsTraversal(11, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {2, 6}, {6, 11}}, 1); // based
        System.out.println(dfsTraversalList.toString());

    }

    public static void dfsTraversal(int n, int[][] edges, int source) {
        adjList = buildUnDirectedGraph(n, edges);
        dfsTraversalList = new ArrayList<>();
        boolean[] visitedArray = new boolean[n + 1];
        Arrays.fill(visitedArray, false);
        int startNode = 1;
        dfs(visitedArray, startNode);
    }

    public static void dfs(boolean[] visited, int start) {
        if (visited[start]) {
            return;
        }

        visited[start] = true;
        dfsTraversalList.add(start);

        for (int i = 0; i < adjList.get(start).size(); i++) {
            int destination = adjList.get(start).get(i);
            dfs(visited, destination);
        }
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

