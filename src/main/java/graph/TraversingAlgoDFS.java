package graph;

import java.util.ArrayList;
import java.util.List;
/*Purpose:
- Graph traversal / exploration.
- Travel deep first: explore as far as possible along a branch before backtracking.
        - Used in: maze solving, puzzle solving, connected components, pathfinding, topological sort.

Key Idea:
- Use recursion (or stack) to go deep first.
- Backtrack when no unvisited neighbors exist.
- Can explore all paths in a graph.

Applications in travel:
- Finding all routes between two places
- Detecting cycles
- Planning routes in a maze*/

public class TraversingAlgoDFS {
    private int V;
    private List<List<Integer>> adjList;

    public TraversingAlgoDFS(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        TraversingAlgoDFS g = new TraversingAlgoDFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        g.dfs(0);
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // undirected
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[V];
        System.out.println("DFS Traversal starting from node " + start + ":");
        dfsUtil(start, visited);
        System.out.println();
    }

    private void dfsUtil(int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");

        for (int v : adjList.get(u)) {
            if (!visited[v]) dfsUtil(v, visited);
        }
    }
}
