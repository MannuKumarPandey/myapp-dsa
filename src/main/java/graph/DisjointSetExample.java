package graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetExample {
	public static void main(String[] args) {
		DisjointSet disjointSet = new DisjointSet(7);

		disjointSet.unionByRank(1, 2);
		disjointSet.unionByRank(2, 3);

		disjointSet.unionByRank(4, 5);
		disjointSet.unionByRank(6, 7);
		disjointSet.unionByRank(5, 6);

		// if 3 and 7 are from same component or not
		if (disjointSet.findUParent(3) == disjointSet.findUParent(7)) {
			System.out.println("Yes 3 and 7 are from the same component of a graph. ");
		} else {
			System.out.println("No  3 and 7 are from the same component of a graph. ");
		}

		disjointSet.unionByRank(3, 4);

		if (disjointSet.findUParent(3) == disjointSet.findUParent(7)) {
			System.out.println("Yes 3 and 7 are from the same component of a graph. ");
		} else {
			System.out.println("No  3 and 7 are from the same component of a graph. ");
		}
	}

}

class DisjointSet {
	List<Integer> rank = new ArrayList<Integer>();
	List<Integer> size = new ArrayList<Integer>();
	List<Integer> parent = new ArrayList<Integer>();

	public DisjointSet(int n) {
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
