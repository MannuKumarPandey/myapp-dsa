package graph;


/*
Kruskal’s Algorithm ke key points:

1. Limitation:
   - Graph me negative weight edges handle karta hai, lekin disconnected graph me complete MST nahi milega.
   - Edge-based approach hai → graph ka edges sort karna padta hai.

2. Core Idea:
   - Sabhi edges ko ascending weight order me sort karo.
   - Ek-ek edge add karo agar wo cycle create na kare.
   - Cycle detect karne ke liye Union-Find (Disjoint Set) data structure use karo.

3. Complexity:
   - Sorting edges: O(E log E)
   - Union-Find operations: nearly O(E α(V)) → α(V) = Inverse Ackermann function
   - Total Complexity: O(E log E)

4. Advantages:
   - Sparse graphs me efficient.
   - Negative weight edges ko handle karta hai.

5. Path Reconstruction:
   - MST me sirf edges ka set milega, path concept nahi applicable.
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MSTKruskal {

    public static void main(String[] args) {
        int V = 6; // number of vertices

        // Graph edges list (src, dest, weight)
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 0, 4));
        edges.add(new Edge(2, 0, 4));
        edges.add(new Edge(2, 1, 2));
        edges.add(new Edge(2, 3, 3));
        edges.add(new Edge(2, 5, 2));
        edges.add(new Edge(2, 4, 4));
        edges.add(new Edge(3, 2, 3));
        edges.add(new Edge(3, 4, 3));
        edges.add(new Edge(4, 2, 4));
        edges.add(new Edge(4, 3, 3));
        edges.add(new Edge(5, 2, 2));
        edges.add(new Edge(5, 4, 3));

        kruskal(edges, V);
    }

    // Kruskal’s Algorithm function
    public static void kruskal(List<Edge> edges, int V) {

        // Step 1: Sort edges ascending order me weight ke according
        edges.sort(Comparator.comparingInt(e -> e.weight));

        // Step 2: Union-Find initialize karte hain
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i; // initially, har vertex apna parent
            rank[i] = 0;   // rank zero
        }

        List<Edge> mst = new ArrayList<>(); // MST ke edges store karenge
        int totalWeight = 0;

        // Step 3: Sabhi edges ko process karte hain
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;

            // Check cycle using find operation
            int setU = find(parent, u);
            int setV = find(parent, v);

            if (setU != setV) { // agar alag sets me hain → cycle nahi banega
                mst.add(edge);  // MST me add karenge
                totalWeight += edge.weight;

                union(parent, rank, setU, setV); // sets merge karenge
            }
        }

        // Step 4: MST print karenge
        System.out.println("Edges in MST:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " → " + edge.dest + " = " + edge.weight);
        }
        System.out.println("Total weight of MST: " + totalWeight);

        /*
        Notes:
        - MST me V-1 edges honge (agar graph connected hai)
        - Disconnected graph me multiple components ke MSTs alag alag milenge
        */
    }

    // Union-Find find operation with path compression
    private static int find(int[] parent, int u) {
        if (parent[u] != u) {
            parent[u] = find(parent, parent[u]); // path compression
        }
        return parent[u];
    }

    // Union-Find union operation by rank
    private static void union(int[] parent, int[] rank, int u, int v) {
        int setU = find(parent, u);
        int setV = find(parent, v);

        if (rank[setU] < rank[setV]) {
            parent[setU] = setV;
        } else if (rank[setU] > rank[setV]) {
            parent[setV] = setU;
        } else {
            parent[setV] = setU;
            rank[setU]++;
        }
    }

    // Edge class
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
}
