package graph;

import java.util.ArrayList;

public class DetectCycleUDUWDFS {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adjList = getUDUWGraphAdjList();
		PrintUDUWGraph(getUDUWGraphAdjList(), 7);

		System.out.println(checkForCycle(adjList, 7));
	}

	private static boolean checkForCycle(ArrayList<ArrayList<Integer>> adjList, int noOfVertices) {
		boolean vis[] = new boolean[noOfVertices + 1];

		// below for loop is for agar bahut sare unconnected component ho given grapgh
		// me
		// to bhi sare ko milakar cycle find kiya ja sake
		for (int i = 0; i <= noOfVertices; i++) {
			if (vis[i] == false) {
				if (dfs(i, -1, adjList, vis) == true) {
					return true;
				}
				;
			}
		}
		return false;
	}

	private static boolean dfs(int node, int parentNode, ArrayList<ArrayList<Integer>> adjList, boolean[] vis) {
		vis[node] = true;

		for (int adjNode : adjList.get(node)) {
			if (vis[adjNode] == false) {
				if (dfs(adjNode, node, adjList, vis) == true) {
					return true;
				}
			} else if (adjNode != parentNode) {
				return true;
			}
		}
		return false;

	}

	public static ArrayList<ArrayList<Integer>> getUDUWGraphAdjList() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int n = 7;
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(1).add(3);
		adj.get(3).add(1);

		adj.get(2).add(5);
		adj.get(5).add(2);

		adj.get(3).add(4);
		adj.get(4).add(3);

		adj.get(3).add(6);
		adj.get(6).add(3);

		adj.get(6).add(7);
		adj.get(7).add(6);

		adj.get(7).add(5);
		adj.get(5).add(7);

		return adj;
	}

	public static void PrintUDUWGraph(ArrayList<ArrayList<Integer>> adjList, int n) {
		for (int i = 1; i <= n; i++) {
			System.out.print(i + " is connected to ");
			for (int j = 0; j < adjList.get(i).size(); j++) {
				System.out.print(adjList.get(i).get(j) + "  ");
			}
			System.out.println();
		}
	}

}
