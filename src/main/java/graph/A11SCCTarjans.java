package graph;


/*
Tarjan's Algorithm ke key points:

1. Limitation:
   - Directed graph me SCC detect karne ke liye use hota hai.
   - Undirected graph me articulation points / bridges detect karne ke liye modify karte hain.
   - Recursive DFS based hai → large graphs me stack overflow ho sakta hai.

2. Core Idea:
   - DFS traversal ke during discovery time aur low-link values maintain karte hain.
   - Low-link value = minimum discovery time reachable from subtree including back edges.
   - SCC detect karte hain jab current node ka low-link == discovery time.
   - Stack maintain karte hain nodes ka, jab tak SCC complete na ho.

3. Complexity:
   - O(V + E), kyunki DFS traversal har vertex aur edge visit karta hai sirf once.

4. Applications:
   - Strongly Connected Components (SCC) detection in directed graphs.
   - Articulation points / bridges detection in undirected graphs.
   - Condensed graph creation, dependency analysis.

5. Notes:
   - Recursive DFS use hoti hai.
   - Stack me nodes store karte hain SCC build karne ke liye.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class A11SCCTarjans {

    private int V; // number of vertices
    private List<List<Integer>> adjList;

    private int time = 0; // discovery time
    private int[] disc, low; // discovery and low-link values
    private boolean[] inStack;
    private Stack<Integer> stack;

    public A11SCCTarjans(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        disc = new int[V];
        Arrays.fill(disc, -1); // -1 means not visited
        low = new int[V];
        inStack = new boolean[V];
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        A11SCCTarjans g = new A11SCCTarjans(8);

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

        System.out.println("Strongly Connected Components:");
        g.SCC();

        /*
        Notes:
        - Output me har SCC ek line me print hogi
        - Directed graph ke liye useful
        - Low-link aur discovery time key concept hai
        */
    }

    // Add directed edge u -> v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    // Tarjan’s SCC main function
    public void SCC() {
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                dfs(i);
            }
        }
    }

    // Recursive DFS
    private void dfs(int u) {
        disc[u] = low[u] = time++;
        stack.push(u);
        inStack[u] = true;

        // Explore all neighbors
        for (int v : adjList.get(u)) {
            if (disc[v] == -1) {
                dfs(v);
                low[u] = Math.min(low[u], low[v]); // update low-link
            } else if (inStack[v]) {
                low[u] = Math.min(low[u], disc[v]); // back edge found
            }
        }

        // If node is root of SCC
        if (low[u] == disc[u]) {
            System.out.print("SCC: ");
            int w;
            do {
                w = stack.pop();
                inStack[w] = false;
                System.out.print(w + " ");
            } while (w != u);
            System.out.println();
        }
    }
}
