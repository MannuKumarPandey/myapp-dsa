package graph;

import java.util.ArrayList;
import java.util.List;


/*
DFS Cycle Detection (Undirected Graph)

1. Limitation:
   - Undirected graph ke liye hi
   - Recursive DFS → large graph me stack overflow risk

2. Core Idea:
   - DFS traversal karte hue parent maintain karo
   - Agar neighbor visited aur parent nahi → cycle exists

3. Complexity:
   - O(V + E)
*/

public class A16CDDFSRecursion {

    private int V;
    private List<List<Integer>> adjList;

    public A16CDDFSRecursion(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        A16CDDFSRecursion g = new A16CDDFSRecursion(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        System.out.println("DFS: Cycle exists? " + g.hasCycle());
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, -1)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int u, boolean[] visited, int parent) {
        visited[u] = true;
        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                if (dfs(v, visited, u)) return true;
            } else if (v != parent) {
                return true; // back edge → cycle
            }
        }
        return false;
    }
}
