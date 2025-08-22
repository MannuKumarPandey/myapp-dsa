package graph;

/*
Prim’s Algorithm ke key points:

1. Limitation:
   - Negative weight edges handle karta hai, lekin disconnected graph me complete MST nahi milega.
   - Vertex-based approach hai → har step me minimum weight edge select karna padta hai.

2. Core Idea:
   - Ek node se start karo aur MST grow karte raho.
   - Har step me ek edge choose karo jo MST me nahi hai aur minimum weight ka ho.
   - PriorityQueue / Min-Heap use karke efficient selection hota hai.

3. Complexity:
   - Using Min-Heap: O(E log V)
   - Simple array: O(V^2)

4. Advantages:
   - Sparse graph me efficient.
   - Negative weight edges handle karta hai.

5. Path Reconstruction:
   - MST me sirf edges ka set milega, path concept nahi applicable.
*/

import java.util.*;

public class MSTPrims {

    public static void main(String[] args) {
        int V = 5; // number of vertices
        int INF = 99999;

        // Graph adjacency list representation
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        // Edges add kar rahe hain (src, dest, weight)
        adjList.get(0).add(new Edge(1, 2));
        adjList.get(0).add(new Edge(3, 6));
        adjList.get(1).add(new Edge(0, 2));
        adjList.get(1).add(new Edge(2, 3));
        adjList.get(1).add(new Edge(3, 8));
        adjList.get(1).add(new Edge(4, 5));
        adjList.get(2).add(new Edge(1, 3));
        adjList.get(2).add(new Edge(4, 7));
        adjList.get(3).add(new Edge(0, 6));
        adjList.get(3).add(new Edge(1, 8));
        adjList.get(4).add(new Edge(1, 5));
        adjList.get(4).add(new Edge(2, 7));

        primMST(adjList, V);
    }

    // Prim’s Algorithm
    public static void primMST(List<List<Edge>> adjList, int V) {

        int[] key = new int[V]; // minimum weight edge for each vertex
        int[] parent = new int[V]; // MST path reconstruction
        boolean[] inMST = new boolean[V]; // MST me vertex include hua ya nahi

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Start from vertex 0
        key[0] = 0;

        // PriorityQueue for selecting minimum key vertex
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.key));
        pq.offer(new Node(0, key[0]));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.id;

            if (inMST[u]) continue; // already included
            inMST[u] = true;

            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.offer(new Node(v, key[v]));
                }
            }
        }

        // Print MST edges and total weight
        int totalWeight = 0;
        System.out.println("Edges in MST:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " → " + i + " = " + key[i]);
            totalWeight += key[i];
        }
        System.out.println("Total weight of MST: " + totalWeight);

        /*
        Notes:
        - MST me V-1 edges honge (agar graph connected hai)
        - Disconnected graph me multiple components ke MSTs alag alag milenge
        */
    }

    // Node class for PriorityQueue
    static class Node {
        int id, key;

        Node(int id, int key) {
            this.id = id;
            this.key = key;
        }
    }

    // Edge class
    static class Edge {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}
