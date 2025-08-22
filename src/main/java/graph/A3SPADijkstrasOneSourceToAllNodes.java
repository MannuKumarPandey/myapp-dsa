package graph;

import java.util.*;

/*Limitation: Dijkstra negative edge weights ke liye kaam nahi karta.
Reason: Algorithm assume karta hai ki jab aap kisi node ko visit karte ho, to aapne already shortest path paa liya hai.
Negative weight hone par ye assumption fail ho jata hai → galat result aa sakta hai.
Solution: Agar graph me negative weights hain → use Bellman-Ford.*/

/*
One Source to All Nodes
Dijkstra single source shortest path ke liye best hai, lekin all-pairs shortest path ke liye nahi.
Dense graphs me agar har node se har node ka shortest path chahiye → Floyd-Warshall ya Johnson’s Algorithm better hai.
*/

/*Dense Graphs me Complexity
Agar graph dense hai (V² edges) → adjacency matrix ke saath Dijkstra ka time complexity O(V²) ho jata hai.
Sparse graph me adjacency list + priority queue use karke O((V+E) log V) efficient hota hai.*/

/*Heuristic Guidance
Dijkstra target oriented search me efficient nahi hai.
Matlab agar aapko sirf ek specific goal node tak shortest path chahiye → Dijkstra har node expand karega.
Solution: Use A* (heuristic guided search) for one source → one target.*/


/*Path Reconstruction
By default, Dijkstra sirf distances deta hai, path nahi.
Agar shortest path bhi chahiye → parent array maintain karna padega.*/


public class A3SPADijkstrasOneSourceToAllNodes {
    public static void main(String[] args) {
        // 5 nodes ka graph
        Graph1 g = new Graph1(5);

        // Edges add kar rahe hain (src, dest and weights)
        g.addEdge(0, 1, 10);
        g.addEdge(0, 4, 5);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 4, 2);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 0, 7);
        g.addEdge(3, 2, 6);
        g.addEdge(4, 1, 3);
        g.addEdge(4, 2, 9);
        g.addEdge(4, 3, 2);

        int source = 0; // Source node 0
        int[] distances = g.dijkstra(source);

        // Source se sabhi nodes ka shortest distance print karenge
        System.out.println("Node " + source + " se sabhi nodes tak shortest distances:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(source + " → " + i + " = " + distances[i]);
        }
    }

}


// Graph ke liye class
class Graph1 {
    private final int vertices; // number of vertices
    private final List<List<Edge>> adjacencyList; // adjacency list me har node ke neighbors store honge

    public Graph1(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);

        // Har vertex ke liye empty list banai taki edges store kar sake
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Directed edge add karne ke liye function
    public void addEdge(int src, int dest, int weight) {
        // src → dest ke liye weight add kar rahe hain
        adjacencyList.get(src).add(new Edge(dest, weight));
    }

    // Dijkstra’s Algorithm: ek source se sabhi nodes tak shortest path
    public int[] dijkstra(int source) {
        int[] dist = new int[vertices];

        // Shuru me sabhi distances ko infinity set karte hain
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Source se source ki distance 0 hoti hai
        dist[source] = 0;

        // PriorityQueue (min-heap) use kar rahe hain taki minimum distance wala node pehle aaye
        // Queue me pair: [distance, node] store hoga
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, source});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0];
            int u = current[1];

            // Agar is node ke liye pehle se chhota distance mil chuka hai, to skip karenge
            if (currentDist > dist[u]) continue;

            // Ab iske sabhi neighbors relax karenge
            for (Edge edge : adjacencyList.get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                // Relaxation: agar naya path chhota hai to update karenge
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;

                    // Priority queue me updated distance add karenge
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        // Har vertex tak ka shortest distance return karenge
        return dist;
    }

    // Edge representation (target + weight)
    static class Edge {
        int target, weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
}
