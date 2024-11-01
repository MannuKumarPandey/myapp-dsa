package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {

	public static void main(String[] args) {
		int V = 5;
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
		int[][] edges = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 2, 1 }, { 2, 3, 2 }, { 3, 4, 1 }, { 4, 2, 2 } };

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

	private static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adjList) {

		List<Edge> edges = new ArrayList<Edge>();

		// O(N+E)

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < adjList.get(i).size(); j++) {
				int adjNode = adjList.get(i).get(j).get(0);
				int wt = adjList.get(i).get(j).get(1);
				int node = i;
				Edge temp = new Edge(i, adjNode, wt);
				edges.add(temp);
			}
		}

		DisjointSet_InKruskal dis = new DisjointSet_InKruskal(V);
		// in MLogM
		Collections.sort(edges);

		int mstWeight = 0;

		// M x 4 x alpha x 2

		// short hone ke bad ek ek edges ko lekar unake ultimate parent find kar kar ke
		// check karte chalate hai
		for (int i = 0; i < edges.size(); i++) {
			int wt = edges.get(i).weight;
			int u = edges.get(i).src;
			int v = edges.get(i).destination;

			if (dis.findUParent(u) != dis.findUParent(v)) {
				mstWeight += wt;
				dis.unionBySize(u, v);
			}

		}
		return mstWeight;
	}

}

class Edge implements Comparable<Edge> {
	int src, destination, weight;

	Edge(int _src, int _dest, int _wt) {
		this.src = _src;
		this.destination = _dest;
		this.weight = _wt;
	}

	// Comparator function used for
	// sorting edgesbased on their weight
	public int compareTo(Edge compareEdge) {
		return this.weight - compareEdge.weight;
	}
}

class DisjointSet_InKruskal {
	List<Integer> rank = new ArrayList<Integer>();
	List<Integer> size = new ArrayList<Integer>();
	List<Integer> parent = new ArrayList<Integer>();

	public DisjointSet_InKruskal(int n) {
		for (int i = 0; i <= n; i++) {
			rank.add(0);
			size.add(1);
			parent.add(i);
		}
	}

	public int findUParent(int node) {
		if (node == parent.get(node)) {
			return node;
		}
		int ulp = findUParent(parent.get(node));
		parent.set(node, ulp);

		return parent.get(node);
	}

	public void unionByRank(int u, int v) {
		int ultimate_parent_u = findUParent(u);
		int ultimate_parent_v = findUParent(v);

		if (ultimate_parent_u == ultimate_parent_v) {
			return;
		}
		if (rank.get(ultimate_parent_u) < rank.get(ultimate_parent_v)) {
			parent.set(ultimate_parent_u, ultimate_parent_v);
		} else if (rank.get(ultimate_parent_v) < rank.get(ultimate_parent_u)) {
			parent.set(ultimate_parent_v, ultimate_parent_u);
		} else {
			parent.set(ultimate_parent_v, ultimate_parent_u);
			int rank_u = rank.get(ultimate_parent_u);
			rank.set(ultimate_parent_u, rank_u + 1);
		}

	}

	public void unionBySize(int u, int v) {
		int ultimate_parent_u = findUParent(u);
		int ultimate_parent_v = findUParent(v);

		if (ultimate_parent_u == ultimate_parent_v) {
			return;
		}
		if (size.get(ultimate_parent_u) < rank.get(ultimate_parent_v)) {
			parent.set(ultimate_parent_u, ultimate_parent_v);
			size.set(ultimate_parent_v, size.get(ultimate_parent_v) + size.get(ultimate_parent_u));
		} else {
			parent.set(ultimate_parent_v, ultimate_parent_u);
			size.set(ultimate_parent_u, size.get(ultimate_parent_v) + size.get(ultimate_parent_u));
		}
	}
}
