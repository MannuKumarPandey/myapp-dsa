package graph;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adjList = getDUWGraphAdjList();
		System.out.println(detectCycle(adjList, 10));

	}

	private static boolean detectCycle(ArrayList<ArrayList<Integer>> adjList, int noOfVertex) {
		int vis[] = new int[noOfVertex + 1];
		int pathVis[] = new int[noOfVertex + 1];

		for (int i = 0; i < noOfVertex; i++) {
			if (vis[i] == 0) {
				if (dfsCheck(i, adjList, vis, pathVis) == true) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis, int[] pathVis) {
		vis[node] = 1;
		pathVis[node] = 1;

		// traverse for adjacent Node
		for (int curNode : adjList.get(node)) {
			if (vis[curNode] == 0) {
				if (dfsCheck(curNode, adjList, vis, pathVis) == true) {
					return true;
				}
			} else if (pathVis[curNode] == 1) {
				return true;
			}
		}
		pathVis[node] = 0;

		return false;
	}

	public static ArrayList<ArrayList<Integer>> getDUWGraphAdjList() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int n = 10;
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(1).add(2);

		adj.get(2).add(3);

		adj.get(3).add(4);
		adj.get(3).add(7);

		adj.get(4).add(5);

		adj.get(7).add(5);

		adj.get(5).add(6);

		adj.get(8).add(2);
		adj.get(8).add(9);

		adj.get(9).add(10);

		adj.get(10).add(8);

		return adj;
	}

}
