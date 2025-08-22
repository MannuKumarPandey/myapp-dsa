package graph;

/*
Union-Find Cycle Detection (Undirected Graph)

1. Limitation:
   - Undirected graph ke liye hi.
   - Edge weights irrelevant.
   - Cycle exist → graph connected ya disconnected dono me detect possible.

2. Core Idea:
   - Har vertex ek set me start hota hai.
   - Edge (u, v) add karte waqt check karo:
       - Agar u aur v same set me hain → cycle exists
       - Otherwise → union(u, v)
   - Path compression + union by rank → efficient.

3. Complexity:
   - O(E * α(V)), α = Inverse Ackermann function ~ almost constant
*/


public class A15CDUnionFind {

    public static boolean hasCycle(int V, int[][] edges) {
        DisjointSet ds = new DisjointSet(V);
        for (int[] edge : edges) {
            if (!ds.union(edge[0], edge[1])) return true; // cycle exists
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 0}}; // cycle exists

        System.out.println("Union-Find: Cycle exists? " + hasCycle(V, edges));
    }

    static class DisjointSet {
        int[] parent, rank;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int u) {
            if (parent[u] != u) parent[u] = find(parent[u]); // path compression
            return parent[u];
        }

        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) return false; // cycle detected

            // union by rank
            if (rank[rootU] < rank[rootV]) parent[rootU] = rootV;
            else if (rank[rootU] > rank[rootV]) parent[rootV] = rootU;
            else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            return true;
        }
    }
}
