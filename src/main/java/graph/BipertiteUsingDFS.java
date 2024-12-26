package graph;

import java.util.ArrayList;

public class BipertiteUsingDFS {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adjList = getUDUWGraphAdjList();
		System.out.println(isBipertiteGraph(adjList, 8));

	}

	private static boolean isBipertiteGraph(ArrayList<ArrayList<Integer>> adjList, int noOfVertex) {
		int color[] = new int[noOfVertex + 1];
		for (int i = 0; i <= noOfVertex; i++) {
			color[i] = -1;
		}

		for (int i = 0; i <= noOfVertex; i++) {
			if (color[i] == -1) {
				if (dfs(i, 0, adjList, color) == false) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean dfs(int node, int colr, ArrayList<ArrayList<Integer>> adjList, int[] color) {

		color[node] = colr;

		for (int curNode : adjList.get(node)) {
			if (color[curNode] == -1) {
				if (dfs(curNode, 1 - colr, adjList, color) == false) {
					return false;
				}
			} else if (color[curNode] == color[node]) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<ArrayList<Integer>> getUDUWGraphAdjList() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int n = 8;
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(2).add(6);
		adj.get(6).add(2);

		adj.get(2).add(3);
		adj.get(3).add(2);

		adj.get(3).add(4);
		adj.get(4).add(3);

		adj.get(6).add(5);
		adj.get(5).add(6);

		adj.get(4).add(5);
		adj.get(5).add(4);

		adj.get(4).add(7);
		adj.get(7).add(4);

		adj.get(7).add(8);
		adj.get(8).add(7);

		return adj;
	}
}
