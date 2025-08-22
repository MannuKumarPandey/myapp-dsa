package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*Purpose:
- Graph traversal / shortest path in unweighted graph.
- Travel layer by layer: explore all neighbors first before going deeper.
- Used in: GPS navigation, social network connections, level order traversal, shortest path in unweighted graphs.

Key Idea:
- Use Queue to maintain the next node to visit.
- Distance from source node is calculated layer by layer.
- Guarantees shortest path (in terms of edges) for unweighted graphs.*/

public class TraversingAlgoBFS {
    private int V;
    private List<List<Integer>> adjList;

    public TraversingAlgoBFS(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        TraversingAlgoBFS g = new TraversingAlgoBFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        g.bfs(0);
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // undirected
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        System.out.println("BFS Traversal starting from node " + start + ":");
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            for (int v : adjList.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
        System.out.println();
    }
}
