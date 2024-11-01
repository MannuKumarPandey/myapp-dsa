package graph;

import java.util.ArrayList;
import java.util.List;

public class NoOfProvincesOrConnectedComponentsByDisjointSet {

	public static void main(String[] args) {
		int V = 8;
		ArrayList<ArrayList<Integer>> adjList = getUDUWGraphAdjList();
	
		int noOfProvinces = noOfProvinces(adjList, V);
		System.out.println("The noOfProvinces: " + noOfProvinces);

	}
	
	public static ArrayList<ArrayList<Integer>> getUDUWGraphAdjList() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int n = 8;
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(2).add(3);
		adj.get(3).add(2);

		adj.get(4).add(5);
		adj.get(5).add(4);

		adj.get(5).add(6);
		adj.get(6).add(5);

		adj.get(7).add(8);
		adj.get(8).add(7);

		return adj;
	}

	private static int noOfProvinces(ArrayList<ArrayList<Integer>> adjList, int V) {
		DisjointSet_NoOfProvinces dis = new DisjointSet_NoOfProvinces(V);

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (adjList.get(i).get(j) == 1) {
					dis.unionBySize(i, j);
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (dis.parent.get(i) == i) {
				count++;
			}
		}
		return count;
	}

}

class DisjointSet_NoOfProvinces {
	List<Integer> rank = new ArrayList<Integer>();
	List<Integer> size = new ArrayList<Integer>();
	List<Integer> parent = new ArrayList<Integer>();

	public DisjointSet_NoOfProvinces(int n) {
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
