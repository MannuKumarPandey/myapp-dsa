package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Limitation: Floyd-Warshall negative weight cycles handle nahi kar sakta properly.
Reason: Agar diagonal element dist[i][i] negative ho jaaye, matlab graph me negative cycle hai.
Solution: Negative cycle detect karke alert karna chahiye.

All-Pairs Shortest Path
Floyd-Warshall har pair (i, j) ke liye shortest path calculate karta hai.
Ye dense graphs ke liye suitable hai kyunki time complexity O(V^3) hai.
Sparse graphs me Johnson’s Algorithm ya Dijkstra from each node better hai.

Time Complexity
Teeno nested loops me O(V^3) time lagta hai.
Space Complexity: O(V^2) matrix store karna padta hai.

Negative Edge Handling
Floyd-Warshall negative edges handle kar sakta hai, lekin negative cycle detect karna alag se check karna padega:
Agar dist[i][i] < 0 → negative weight cycle exist karta hai.

Path Reconstruction
By default, ye algorithm sirf distance matrix deta hai.
Agar actual path chahiye → ek parent matrix maintain karna padega aur update karte rehna hoga relaxation step me.*/


public class A5SPAFloydWarshallAllNodestoAllNodes {

    public static void main(String[] args) {
        int V = 4; // number of vertices
        int INF = 99999; // Infinity define kar rahe hain

        // Graph ko adjacency list ke form me define kar rahe hain
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Edges add kar rahe hain (src, dest, weight)
        adjList.get(0).add(new Edge(1, 5));
        adjList.get(0).add(new Edge(3, 10));
        adjList.get(1).add(new Edge(2, 3));
        adjList.get(2).add(new Edge(3, 1));

        // Convert adjacency list to matrix for Floyd-Warshall
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(graph[i], INF); // initially infinity
            graph[i][i] = 0; // self distance 0
            for (Edge edge : adjList.get(i)) {
                graph[i][edge.dest] = edge.weight;
            }
        }

        // Call Floyd-Warshall function
        floydWarshall(graph, V, INF);
    }

    // Floyd-Warshall Algorithm
    public static void floydWarshall(int[][] dist, int V, int INF) {


        // Core Floyd-Warshall logic
        for (int k = 0; k < V; k++) { // Intermediate node
            for (int i = 0; i < V; i++) { // Source node
                for (int j = 0; j < V; j++) { // Destination node
                    // Relaxation step: agar i->k->j ka path chhota hai to update karenge
                    if (dist[i][k] != INF && dist[k][j] != INF
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print shortest distances
        System.out.println("All-Pairs Shortest Distances:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }


    }

    // Edge representation (dest + weight)
    static class Edge {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}
