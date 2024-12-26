package graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BFSTraversalAdjListIterativeWay {

    public static void main(String[] args) {
        // No. of nodes in graph
        int N = 4;

        // Creating adjacency list
        // for representing graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);

        // Following is BFS Traversal
        // starting from vertex 2
        bfsTraversal(adj, N, 2);
    }

    static void bfsTraversal(List<List<Integer>> adj, int N, int source) {
        // Initially mark all nodes as false
        boolean[] visitedArray = new boolean[N + 1];
        Arrays.fill(visitedArray, false);

        // Initialize distance array with 0
        int[] distanceArray = new int[N + 1];
        Arrays.fill(distanceArray, 0);

        List<Integer> v = new ArrayList<>();
        v.add(source);

        // Initially mark the starting
        // source as 0 and visited as true
        distanceArray[source] = 0;
        visitedArray[source] = true;

        // Call the BFS function
        bfs(1, N, visitedArray, distanceArray, v, adj);
    }

    static void bfs(int curr, int N, boolean[] vis, int[] distanceArray, List<Integer> v, List<List<Integer>> adj) {
        while (curr <= N) {
            // Current node
            int node = v.get(curr - 1);
            System.out.print(node + ", ");

            for (int i = 0; i < adj.get(node).size(); i++) {
                // Adjacent node
                int next = adj.get(node).get(i);

                if ((!vis[next]) && (distanceArray[next] < distanceArray[node] + 1)) {
                    // Stores the adjacent node
                    v.add(next);

                    // Increases the distance
                    distanceArray[next] = distanceArray[node] + 1;

                    // Mark it as visited
                    vis[next] = true;
                }
            }
            curr += 1;
        }
    }
}

