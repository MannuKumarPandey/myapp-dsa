package graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologySortDFS {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adjList = getDUWGraphAdjList();
		int[] topoSort = topoSort(adjList, 6);
		for (int dd : topoSort) {
			System.out.print(dd + " ");
		}

	}

	private static int[] topoSort(ArrayList<ArrayList<Integer>> adjList, int noOfVertex) {
		int vis[] = new int[noOfVertex];
		Stack<Integer> stack = new Stack<Integer>(); // to store the element for toposort

		for (int i = 0; i < noOfVertex; i++) {
			if (vis[i] == 0) {
				dfs(i, adjList, vis, stack);
			}
		}

		int ans[] = new int[noOfVertex];
		int i = 0;
		while (!stack.isEmpty()) {
			ans[i++] = stack.peek();
			stack.pop();
		}
		return ans;
	}

	private static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis, Stack<Integer> stack) {
		vis[node] = 1;

		// traverse for adjacent Node
		for (int curNode : adjList.get(node)) {
			if (vis[curNode] == 0) {
				dfs(curNode, adjList, vis, stack);
			}
		}
		stack.push(node);
	}

	public static ArrayList<ArrayList<Integer>> getDUWGraphAdjList() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int n = 5;
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(2).add(3);

		adj.get(3).add(1);

		adj.get(4).add(0);
		adj.get(4).add(1);

		adj.get(5).add(0);
		adj.get(5).add(2);

		return adj;
	}

}
