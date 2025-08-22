package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/*
Kosaraju's Algorithm ke key points:

1. Limitation:
   - Directed graph me SCC detect karne ke liye use hota hai.
   - Graph me negative weights ka issue nahi hai (weights ka relevance SCC me nahi).
   - Recursive DFS use hoti hai → large graphs me stack overflow ho sakta hai.

2. Core Idea:
   - Step 1: DFS traversal aur finish time ke according nodes ko stack me push karo.
   - Step 2: Graph ko transpose karo (saare edges reverse karo).
   - Step 3: Stack ke nodes pop karte hue DFS on transposed graph → har DFS ek SCC detect karega.

3. Complexity:
   - O(V + E), kyunki 2 DFS traverse har vertex aur edge visit karta hai sirf once.

4. Applications:
   - Strongly Connected Components (SCC) detection in directed graphs.
   - Condensation of graph.
   - Dependency analysis in tasks, package/module systems.

5. Notes:
   - Stack ka use finish time ke order maintain karne ke liye hota hai.
   - Transpose graph me DFS se SCC easily detect hota hai.
*/

public class A10SCCKosaraju {

    private int V;
    private List<List<Integer>> adjList;

    public A10SCCKosaraju(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        A10SCCKosaraju g = new A10SCCKosaraju(8);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 3);
        g.addEdge(6, 5);
        g.addEdge(6, 7);
        g.addEdge(7, 6);

        g.SCC();

        /*
        Notes:
        - Output me har SCC ek line me print hogi
        - Directed graph ke liye useful
        - Stack aur transpose key concepts hain
        */
    }

    // Add directed edge u -> v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    // Kosaraju's Algorithm main function
    public void SCC() {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Step 1: DFS and push finished nodes to stack
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        // Step 2: Transpose graph
        List<List<Integer>> transposed = transposeGraph();

        // Step 3: DFS on transposed graph in stack order
        Arrays.fill(visited, false);
        System.out.println("Strongly Connected Components:");
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                dfsTranspose(node, visited, transposed);
                System.out.println();
            }
        }
    }

    // Step 1: DFS and push finish time
    private void fillOrder(int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int v : adjList.get(u)) {
            if (!visited[v]) fillOrder(v, visited, stack);
        }
        stack.push(u);
    }

    // Step 2: Transpose graph
    private List<List<Integer>> transposeGraph() {
        List<List<Integer>> transposed = new ArrayList<>();
        for (int i = 0; i < V; i++) transposed.add(new ArrayList<>());

        for (int u = 0; u < V; u++) {
            for (int v : adjList.get(u)) {
                transposed.get(v).add(u);
            }
        }
        return transposed;
    }

    // Step 3: DFS on transposed graph
    private void dfsTranspose(int u, boolean[] visited, List<List<Integer>> transposed) {
        visited[u] = true;
        System.out.print(u + " ");
        for (int v : transposed.get(u)) {
            if (!visited[v]) dfsTranspose(v, visited, transposed);
        }
    }
}
