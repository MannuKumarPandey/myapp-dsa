package alltemplates;

import java.util.List;

public class DFSonGraphRecursive {
    
    public void dfsTraversal(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }

    public void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        System.out.println(node);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }


}
