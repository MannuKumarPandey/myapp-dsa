package graph;

import java.util.*;
/*
Limitation:
1. Negative weight cycles graph me exist kare → shortest path define nahi hota.
2. Sparse graphs me efficient, dense graphs me Floyd-Warshall simple option ho sakta hai.
*/

/*
Core Idea:
1. Add a new node 's' connected to all nodes with weight 0.
2. Run Bellman-Ford from 's' to calculate potential h(v) for each vertex v.
3. Reweight edges: w'(u,v) = w(u,v) + h(u) - h(v) → all edges non-negative.
4. Run Dijkstra from each vertex with reweighted edges.
5. Convert distances back using original weights.
*/
public class A7SPAJohnsonAllNodesToAllNodes {

    public static void main(String[] args) {
        int V = 5; // number of vertices

        // Graph adjacency list representation
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        // Edges add kar rahe hain (src, dest, weight)
        adjList.get(0).add(new Edge(1, -1));
        adjList.get(0).add(new Edge(2, 4));
        adjList.get(1).add(new Edge(2, 3));
        adjList.get(1).add(new Edge(3, 2));
        adjList.get(1).add(new Edge(4, 2));
        adjList.get(3).add(new Edge(2, 5));
        adjList.get(3).add(new Edge(1, 1));
        adjList.get(4).add(new Edge(3, -3));

        johnson(adjList, V);
    }

    // Johnson's Algorithm
    public static void johnson(List<List<Edge>> adjList, int V) {


        // Step 1: Add virtual node
        int newV = V + 1;
        List<List<Edge>> newAdj = new ArrayList<>();
        for (int i = 0; i < newV; i++) newAdj.add(new ArrayList<>());
        for (int i = 0; i < V; i++) {
            for (Edge edge : adjList.get(i)) {
                newAdj.get(i).add(new Edge(edge.dest, edge.weight));
            }
        }
        // Virtual node s = V
        for (int i = 0; i < V; i++) newAdj.get(V).add(new Edge(i, 0));

        // Step 2: Bellman-Ford from virtual node
        int[] h = new int[newV];
        Arrays.fill(h, Integer.MAX_VALUE);
        h[V] = 0; // distance to itself 0

        for (int i = 1; i <= newV - 1; i++) {
            for (int u = 0; u < newV; u++) {
                for (Edge edge : newAdj.get(u)) {
                    int v = edge.dest;
                    int w = edge.weight;
                    if (h[u] != Integer.MAX_VALUE && h[u] + w < h[v]) {
                        h[v] = h[u] + w;
                    }
                }
            }
        }

        // Extra iteration to detect negative cycle
        for (int u = 0; u < newV; u++) {
            for (Edge edge : newAdj.get(u)) {
                int v = edge.dest;
                int w = edge.weight;
                if (h[u] != Integer.MAX_VALUE && h[u] + w < h[v]) {
                    System.out.println("Graph me negative weight cycle exist karta hai. Johnson’s Algorithm fail.");
                    return;
                }
            }
        }

        /*
        Step 3: Reweight edges
        w'(u,v) = w(u,v) + h(u) - h(v)
        Sabhi edges ab non-negative ho gaye → Dijkstra use kar sakte hain
        */
        List<List<Edge>> reweighted = new ArrayList<>();
        for (int i = 0; i < V; i++) reweighted.add(new ArrayList<>());
        for (int u = 0; u < V; u++) {
            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                int w = edge.weight + h[u] - h[v];
                reweighted.get(u).add(new Edge(v, w));
            }
        }

        // Step 4: Run Dijkstra from each vertex
        for (int u = 0; u < V; u++) {
            int[] dist = dijkstra(reweighted, u, V);
            // Step 5: Convert back original distances
            System.out.println("Shortest distances from node " + u + ":");
            for (int v = 0; v < V; v++) {
                if (dist[v] == Integer.MAX_VALUE) {
                    System.out.println(u + " → " + v + " = INF");
                } else {
                    // convert back original distance
                    System.out.println(u + " → " + v + " = " + (dist[v] - h[u] + h[v]));
                }
            }
            System.out.println();
        }
    }

    // Standard Dijkstra using adjacency list
    public static int[] dijkstra(List<List<Edge>> adjList, int source, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        pq.offer(new Node(source, 0));

        boolean[] visited = new boolean[V];

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.id;
            if (visited[u]) continue;
            visited[u] = true;

            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                int w = edge.weight;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }
        return dist;
    }

    // Edge class
    static class Edge {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Node class for priority queue
    static class Node {
        int id, f;

        Node(int id, int f) {
            this.id = id;
            this.f = f;
        }
    }
}
