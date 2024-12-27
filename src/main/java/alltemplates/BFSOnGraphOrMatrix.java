package alltemplates;

import java.util.LinkedList;
import java.util.Queue;

public class BFSOnGraphOrMatrix {
    public void bfs(int[][] graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);

            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}
