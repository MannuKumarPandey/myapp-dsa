package alltemplates;

import java.util.Stack;

public class DFSOnGraphIterative {
    public void dfs(int[][] graph, int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                System.out.println(node);
                for (int neighbor : graph[node]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}
