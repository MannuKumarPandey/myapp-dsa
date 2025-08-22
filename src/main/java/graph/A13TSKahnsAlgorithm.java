package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Kahn's Algorithm ke key points:

1. Limitation:
   - Directed Acyclic Graph (DAG) ke liye hi kaam karta hai.
   - Agar cycle hai → topological sort possible nahi.
   - BFS based approach hai → queue use karte hain.

2. Core Idea:
   - Har vertex ka indegree calculate karo.
   - Queue me vertices add karo jinka indegree 0 ho.
   - Queue se vertex remove karte hue neighbors ka indegree reduce karo.
   - Agar neighbor ka indegree 0 ho jaye → queue me add karo.
   - Queue khatam hone ke baad agar sab vertices processed nahi → cycle exist karta hai.

3. Complexity:
   - O(V + E), kyunki har vertex aur edge process hota hai once.

4. Applications:
   - Task scheduling, course prerequisite problems
   - Build systems, dependency resolution

5. Notes:
   - Queue based BFS approach
   - Indegree array maintain karna important
*/


public class A13TSKahnsAlgorithm {

    private int V; // number of vertices
    private List<List<Integer>> adjList;

    public A13TSKahnsAlgorithm(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        A13TSKahnsAlgorithm g = new A13TSKahnsAlgorithm(6);

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
        - Indegree array aur queue key concepts hain
        */
    }

    // Add directed edge u -> v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    // Kahn's Algorithm for Topological Sorting
    public void topologicalSort() {
        int[] indegree = new int[V];

        // Step 1: calculate indegree of each vertex
        for (int u = 0; u < V; u++) {
            for (int v : adjList.get(u)) {
                indegree[v]++;
            }
        }

        // Step 2: add vertices with indegree 0 to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        List<Integer> topoOrder = new ArrayList<>();
        int count = 0; // to detect cycle

        // Step 3: process queue
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);
            count++;

            for (int v : adjList.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // Step 4: check for cycle
        if (count != V) {
            System.out.println("Graph contains a cycle. Topological sort not possible.");
        } else {
            System.out.println("Topological Order:");
            for (int node : topoOrder) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
