package graph;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodesDFS {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adjList = getDUWGraphAdjList();
		List<Integer> list = eventualSafeNode(adjList, 11);
		for(int dd: list) {
			System.out.print(dd+" ");
		}

	}

	private static List<Integer> eventualSafeNode(ArrayList<ArrayList<Integer>> adjList, int noOfVertex) {
		int vis[] = new int[noOfVertex + 1];
		int pathVis[] = new int[noOfVertex + 1];

		int check[] = new int[noOfVertex + 1];

		for (int i = 0; i < noOfVertex; i++) {
			if (vis[i] == 0) {
				dfsCheck(i, adjList, vis, pathVis, check);
			}
		}
		List<Integer> safeNodes = new ArrayList<>();
		for(int i = 0; i< noOfVertex; i++) {
			if(check[i] == 1) {
				safeNodes.add(i);
			}
		}
		return safeNodes;
	}

	private static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis, int[] pathVis,
			int[] check) {
		vis[node] = 1;
		pathVis[node] = 1;
		check[node]= 0;
		// traverse for adjacent Node
		for (int curNode : adjList.get(node)) {
			if (vis[curNode] == 0) {
				if(dfsCheck(curNode, adjList, vis, pathVis, check)==true) {
					return true;
				};
			}
			else if(pathVis[curNode] == 1) {
				return true;
			}
		}
		check[node] = 1;
		pathVis[node] = 0;
		return false;
	}

	public static ArrayList<ArrayList<Integer>> getDUWGraphAdjList() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int n = 11;
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(0).add(1);

		adj.get(1).add(2);

		adj.get(2).add(3);

		adj.get(3).add(4);
		adj.get(3).add(5);

		adj.get(4).add(6);
		adj.get(5).add(6);

		adj.get(6).add(7);

		adj.get(8).add(1);
		adj.get(8).add(9);

		adj.get(9).add(10);

		adj.get(10).add(8);
		adj.get(11).add(9);

		return adj;
	}

}
