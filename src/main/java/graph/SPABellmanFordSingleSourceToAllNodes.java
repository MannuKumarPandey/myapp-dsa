package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Limitation: Bellman-Ford negative weight cycles ko handle nahi kar sakta.
Reason: Algorithm me distances relax karte hain, lekin agar graph me negative weight cycle hai to distances continuously reduce hote rahenge → shortest path define nahi hota.
Solution: Negative weight cycle detect ho jaata hai aur shortest path return nahi hota. Algorithm ko cycle detection ke liye modify kiya ja sakta hai.*/

/*
One Source to All Nodes
Bellman-Ford bhi single source shortest path algorithm hai, yaani ek source node se sabhi nodes tak shortest distance calculate karta hai.
All-pairs shortest path ke liye Bellman-Ford inefficient hai (time complexity O(V*E*V) agar sab nodes se run karein).
Dense graphs me Floyd-Warshall ya sparse graphs me Johnson’s Algorithm better choice hai.
*/

/*Time Complexity
Bellman-Ford ka time complexity O(V*E) hai, yahan V = number of vertices, E = number of edges.
Sparse graphs me Dijkstra adjacency list + priority queue O((V+E) log V) se efficient hai.
Dense graphs me Floyd-Warshall O(V³) use kar sakte hain.
*/

/*Negative Edge Handling
Advantage: Bellman-Ford negative edge weights ko handle kar sakta hai, unlike Dijkstra.
Limitation: Agar graph me negative weight cycle hai, algorithm valid shortest path return nahi karega.
Solution: Extra iteration ke baad check karte hain agar distances ab bhi reduce ho rahe hain → negative cycle detect karte hain.
*/

/*Path Reconstruction
By default, Bellman-Ford sirf distances deta hai, path nahi.
Agar shortest path bhi chahiye → parent array maintain karna padega, har relaxation me parent update karenge.
*/

public class SPABellmanFordSingleSourceToAllNodes {
    public static void main(String[] args) {
        // 5 nodes ka graph
        GraphBF g = new GraphBF(5);

        // Edges add kar rahe hain (src, dest, weight)
        g.addEdge(0, 1, -1);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 4, 2);
        g.addEdge(3, 2, 5);
        g.addEdge(3, 1, 1);
        g.addEdge(4, 3, -3);

        int source = 0; // Source node 0
        int[] distances = g.bellmanFord(source);

        if (distances != null) {
            // Source se sabhi nodes ka shortest distance print karenge
            System.out.println("Node " + source + " se sabhi nodes tak shortest distances:");
            for (int i = 0; i < distances.length; i++) {
                System.out.println(source + " → " + i + " = " + distances[i]);
            }
        } else {
            System.out.println("Graph me negative weight cycle hai, shortest path define nahi hai!");
        }
    }
}


// Graph ke liye class
class GraphBF {
    private final int vertices; // number of vertices
    private final List<Edge> edges; // Graph ke sabhi edges ko store karenge

    public GraphBF(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    // Edge add karne ka function
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // Bellman-Ford Algorithm: ek source se sabhi nodes tak shortest path
    public int[] bellmanFord(int source) {
        int[] dist = new int[vertices];

        // Shuru me sabhi distances ko infinity set karte hain
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Source se source ki distance 0 hoti hai
        dist[source] = 0;

        // V-1 times relax sabhi edges
        for (int i = 1; i <= vertices - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;
                int w = edge.weight;

                // Relaxation step: agar naya path chhota hai to update karenge
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Extra iteration: agar ab bhi distance reduce ho raha hai → negative cycle exist karta hai
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                // Negative cycle detect
                return null;
            }
        }

        // Har vertex tak ka shortest distance return karenge
        return dist;
    }

    // Edge representation (src, dest + weight)
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
}
