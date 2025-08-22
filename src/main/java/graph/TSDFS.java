package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
DFS based Topological Sorting ke key points:

1. Limitation:
   - Directed Acyclic Graph (DAG) ke liye hi kaam karta hai.
   - Agar cycle hai → topological sort possible nahi.
   - Recursive DFS → large graph me stack overflow ho sakta hai.

2. Core Idea:
   - DFS traversal karte hue vertex visit karo.
   - Recursive DFS ke baad vertex ko stack me push karo.
   - Stack ke reverse order me vertices → topological sort order.

3. Complexity:
   - O(V + E), kyunki DFS har vertex aur edge visit karta hai once.

4. Applications:
   - Task scheduling, course prerequisites
   - Build systems, dependency resolution

5. Notes:
   - Recursive DFS + stack key concept
   - Stack reverse order me topological order dega
*/


public class TSDFS {

    private int V;
    private List<List<Integer>> adjList;

    public TSDFS(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        TSDFS g = new TSDFS(6);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topologicalSort();

        /*
        Notes:
        - Output me topological order print hogi
        - DAG me hi possible hai
        - DFS + stack key concept hai
        */
    }

    // Add directed edge u -> v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    // DFS based Topological Sort
    public void topologicalSort() {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        System.out.println("Topological Order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    // Recursive DFS
    private void dfs(int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;

        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                dfs(v, visited, stack);
            }
        }

        stack.push(u); // push after visiting all neighbors
    }
}
