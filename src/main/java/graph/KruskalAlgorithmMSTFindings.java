package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithmMSTFindings {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        int mstWt = spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + mstWt);

    }

    // Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Edge1> edges = new ArrayList<Edge1>();
        // O(N + E)
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                int node = i;
                Edge1 temp = new Edge1(i, adjNode, wt);
                edges.add(temp);
            }
        }
        DisjointSet3 ds = new DisjointSet3(V);
        // M log M
        Collections.sort(edges); // Edge ko wt ke basis par increasing order me sort kiya so that har bar chota wt ka edge pahle aye
        int mstWt = 0;
        // M x 4 x alpha x 2
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            if (ds.findUPar(u) != ds.findUPar(v)) { // Agar dono nodes ka ultimate parents same hai to wo same component me hone ki vajah se unko add karne ki jarurat nahi hai
                mstWt += wt;
                ds.unionBySize(u, v);// yha kisi bhi ek method se 2 nodes ko jod sakte hai either by unionByRank or unionBySize
            }
        }

        return mstWt;
    }
}

class DisjointSet3 {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet3(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v)
            return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v)
            return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Edge1 implements Comparable<Edge1> {
    int src, dest, weight;

    Edge1(int _src, int _dest, int _wt) {
        this.src = _src;
        this.dest = _dest;
        this.weight = _wt;
    }

    // Comparator function used for
    // sorting edgesbased on their weight
    public int compareTo(Edge1 compareEdge) {
        return this.weight - compareEdge.weight;
    }
};


