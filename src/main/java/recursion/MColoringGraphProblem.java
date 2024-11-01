package recursion;

import java.util.ArrayList;
import java.util.List;

public class MColoringGraphProblem {
	public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) {
		// Your code here
		int n = G.length;
		if (solve(i, G, color, n, C) == true)
			return true;
		return false;
	}

	private static boolean isSafe(int node, List<Integer>[] G, int[] color, int n, int col) {
		for (int it : G[node]) {
			if (color[it] == col)
				return false;
		}
		return true;
	}

	private static boolean solve(int node, List<Integer>[] G, int[] color, int n, int m) {
		if (node == n)
			// base condition if we have reached to node n means from i to n we have already
			// colored all
			// the nodes from M colors so yes it can be colored
			return true;

		for (int i = 1; i <= m; i++) {
			// if not then try from 1 to M colors to be colored the same node
			// call isSafe() method to know is it safe to color that node with i color
			if (isSafe(node, G, color, n, i)) {
				color[node] = i;
				if (solve(node + 1, G, color, n, m) == true)
					// if we get any true as result then no need to call recursion further
					return true;
				color[node] = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int N = 4, M = 3; // N is no of vertices , M is number of colors

		// creating adjList for the graph
		List<Integer>[] G = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			G[i] = new ArrayList<>();
		}
		G[0].add(1);
		G[1].add(0);
		G[1].add(2);
		G[2].add(1);
		G[2].add(3);
		G[3].add(2);
		G[3].add(0);
		G[0].add(3);
		G[0].add(2);
		G[2].add(0);
		int[] color = new int[N]; // maintaining the color array for their indexes
		boolean ans = graphColoring(G, color, 0, M);
		if (ans == true)
			System.out.println("1");
		else
			System.out.println("0");
	}

}
