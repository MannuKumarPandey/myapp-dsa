package graph;

import java.util.*;

/*
Tarjan's Algorithm for Articulation Points & Bridges

1. Limitation:
   - Undirected graph me hi use hota hai.
   - Recursive DFS → large graphs me stack overflow ka risk.
   - Negative/positive weights ka issue nahi, graph unweighted ya weighted dono me kaam karega.

2. Core Idea:
   - DFS traversal karte hain aur har vertex ke liye discovery time aur low-link value calculate karte hain.
   - Articulation Point (AP): Vertex remove karne par graph disconnected ho jaye.
   - Bridge: Edge remove karne par graph disconnected ho jaye.
   - Low-link value = minimum discovery time reachable from vertex subtree including back edges.

3. Complexity:
   - O(V + E), kyunki DFS har vertex aur edge visit karta hai once.

4. Applications:
   - Network reliability, critical nodes & edges detection
   - Vulnerability analysis
   - Graph connectivity analysis

5. Notes:
   - DFS me parent maintain karna zaroori.
   - Root vertex special case: root ke multiple children → AP.
*/


public class ArticulationPointsBridgesTarjansAlgo {

    private int V;
    private List<List<Integer>> adjList;
    private int time;

    public ArticulationPointsBridgesTarjansAlgo(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());
        time = 0;
    }

    public static void main(String[] args) {
        ArticulationPointsBridgesTarjansAlgo g = new ArticulationPointsBridgesTarjansAlgo(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);

        g.findArticulationPointsAndBridges();

        /*
        Notes:
        - Articulation Points = critical nodes, remove karne par graph disconnected
        - Bridges = critical edges
        - DFS + low-link concept key hai
        */
    }

    // Add undirected edge
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    // Main function
    public void findArticulationPointsAndBridges() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        Set<Integer> articulationPoints = new HashSet<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, disc, low, parent, articulationPoints);
            }
        }

        // Print articulation points
        System.out.println("Articulation Points:");
        for (int ap : articulationPoints) {
            System.out.println(ap);
        }
    }

    private void dfs(int u, boolean[] visited, int[] disc, int[] low, int[] parent, Set<Integer> aps) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0; // child count for root vertex

        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v, visited, disc, low, parent, aps);

                // Low-link update
                low[u] = Math.min(low[u], low[v]);

                // Articulation Point check
                if (parent[u] == -1 && children > 1) {
                    aps.add(u); // root with multiple children
                }
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    aps.add(u);
                }

                // Bridge check
                if (low[v] > disc[u]) {
                    System.out.println("Bridge: " + u + " - " + v);
                }

            } else if (v != parent[u]) {
                // Back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
