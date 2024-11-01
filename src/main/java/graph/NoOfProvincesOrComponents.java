package graph;

import java.util.ArrayList;

public class NoOfProvincesOrComponents {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adjList = getUDUWGraphAdjList();
		int n = 8;

		// create a visited array to contain the details of the visited nodes
		boolean[] vis = new boolean[n + 1];

		// starting node will be given from where we need to start the BFS traversal

		int counter = 0;
		for (int i = 1; i <= n; i++) { // since given graph was 1 biased so starting from 1
			if (vis[i] == false) {
				vis = dfs(adjList, i, vis);
				counter++;
			}
		}
		System.out.println("Number of provinces are : " + counter);
	}

	private static boolean[] dfs(ArrayList<ArrayList<Integer>> adj, int startNode, boolean vis[]) {

		vis[startNode] = true;

		for (int h : adj.get(startNode)) {
			if (vis[h] == false) {
				dfs(adj, h, vis);
			}
		}
		return vis;
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
}
