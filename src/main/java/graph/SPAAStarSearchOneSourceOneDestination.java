package graph;

import java.util.*;
 /*
Limitation:
1. Negative edge weights nahi handle karta (Dijkstra ki tarah).
2. One source → one target ke liye efficient, all nodes ke liye nahi.
3. Heuristic admissible hona chahiye, nahi to optimal path guarantee nahi hota.
*/

/*
Core Idea:
f(n) = g(n) + h(n)
g(n) = cost from start to current node
h(n) = estimated cost from current node to target (heuristic)
f(n) = total estimated cost
*/

/*
Notes:
- Heuristic h(n) admissible aur consistent hona chahiye.
- Admissible: h(n) kabhi overestimate nahi kare actual shortest distance ko.
- Consistent: h(n) satisfy kare triangle inequality → optimal path guarantee.
- Efficient for one source → one target.
*/

// A* Search Algorithm: One Source to One Target
public class SPAAStarSearchOneSourceOneDestination {

    public static void main(String[] args) {
        int V = 6; // number of nodes
        int INF = 99999;

        // Graph adjacency list representation
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        // Edges add kar rahe hain (src, dest, weight)
        adjList.get(0).add(new Edge(1, 1));
        adjList.get(0).add(new Edge(2, 4));
        adjList.get(1).add(new Edge(2, 2));
        adjList.get(1).add(new Edge(3, 5));
        adjList.get(2).add(new Edge(3, 1));
        adjList.get(3).add(new Edge(4, 3));
        adjList.get(4).add(new Edge(5, 2));

        int source = 0;
        int target = 5;

        aStar(adjList, source, target, V);
    }

    // A* Algorithm function
    public static void aStar(List<List<Edge>> adjList, int source, int target, int V) {


        // Heuristic function (example: straight-line distance / Manhattan distance)
        int[] h = new int[]{7, 6, 2, 1, 1, 0}; // h[target]=0

        int[] gScore = new int[V]; // distance from source
        Arrays.fill(gScore, Integer.MAX_VALUE);
        gScore[source] = 0;

        // PriorityQueue based on f(n) = g(n) + h(n)
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        pq.offer(new Node(source, gScore[source] + h[source]));

        int[] parent = new int[V]; // path reconstruction
        Arrays.fill(parent, -1);

        boolean[] visited = new boolean[V];

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.id;

            if (visited[u]) continue;
            visited[u] = true;

            // Target node mil gaya → exit
            if (u == target) break;

            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                int tentativeG = gScore[u] + weight;

                if (tentativeG < gScore[v]) {
                    gScore[v] = tentativeG;
                    parent[v] = u;
                    pq.offer(new Node(v, gScore[v] + h[v]));
                }
            }
        }

        // Shortest path reconstruction
        List<Integer> path = new ArrayList<>();
        int node = target;
        while (node != -1) {
            path.add(node);
            node = parent[node];
        }
        Collections.reverse(path);

        System.out.println("Shortest path from " + source + " to " + target + ": " + path);
        System.out.println("Total cost: " + gScore[target]);


    }

    // Node class for priority queue
    static class Node {
        int id, f; // node id and f(n)

        Node(int id, int f) {
            this.id = id;
            this.f = f;
        }
    }

    // Edge representation
    static class Edge {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}
