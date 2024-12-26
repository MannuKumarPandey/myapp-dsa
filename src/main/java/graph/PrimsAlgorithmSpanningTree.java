package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

//Class to form pairs
class Pair implements Comparable<Pair> {
    int vertex;
    int weight;

    Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public int compareTo(Pair that) {
        return this.weight - that.weight;
    }
}

class PrimsAlgorithmSpanningTree {

    //Function of spanning tree
    static int spanningTree(int noOfVertices, int noOfEdges, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < noOfVertices; i++) {
            adj.add(new ArrayList<Pair>());
        }


        //Input Matrix se Adjacency List ka preparation
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        //Priority Queue ko lena instead of Queue so that we can get all the min edge values at first
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(0, 0)); // Starting vertex as 0 so its distance from 0 to 0 will be 0.


        int[] visitedArray = new int[noOfVertices];  // visitedArray integer type ka banaya hai
        // so agar kisi index ki value 1 ho means wo already
        int totalDistance = 0;
        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            int v = node.vertex;
            int wt = node.weight;
            if (visitedArray[v] == 1)
                continue;

            totalDistance += wt;
            visitedArray[v] = 1;
            for (Pair it : adj.get(v)) {
                if (visitedArray[it.vertex] == 0) {
                    pq.add(new Pair(it.vertex, it.weight));
                }
            }
        }
        return totalDistance;
    }

    // Driver code
    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };

        // Function call
        System.out.println(spanningTree(3, 3, graph));
    }
}

