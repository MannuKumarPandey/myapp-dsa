package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DFSTraversalUsingExternalStack {

    public static void main(String[] args) {
        System.out.println(dfsTraversal(7, new int[][]{{1, 0}, {1, 2}, {1, 3}, {3, 7}}, 1).toString()); // 0
        // index
        // based
        System.out.println(
                dfsTraversal(11, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {2, 6}, {6, 11}}, 1)
                        .toString());
        // 1 index based

    }

    public static ArrayList<Integer> dfsTraversal(int n, int[][] edges, int source) {
        ArrayList<ArrayList<Integer>> adjList = buildUnDirectedGraph(n, edges);
        boolean[] visitedArray = new boolean[n + 1];
        Arrays.fill(visitedArray, false);
        int startNode = 1;
        return dfs(adjList, visitedArray, startNode);
    }

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adjList, boolean visitedArray[], int source) {
        ArrayList<Integer> dfsTraversalList = new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(source);
        while (!stack.isEmpty()) {
            int listC = stack.pop();
            if (!visitedArray[listC]) {
                visitedArray[listC] = true;
                dfsTraversalList.add(listC);
            }
            ArrayList<Integer> childrens = adjList.get(listC);

            for (Integer c : childrens) {
                if (!visitedArray[c]) {
                    stack.push(c);
                }
            }
        }
        return dfsTraversalList;
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

