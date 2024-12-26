package graph;

import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraphTopo {

	private static class Pair {
		int first, second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) {
		int n = 6, m = 7;
		int edges[][] = { { 0, 1, 2 }, { 0, 4, 1 }, { 4, 5, 4 }, { 4, 2, 2 }, { 1, 2, 3 }, { 2, 3, 6 }, { 5, 3, 1 } };
		int result[] = shortestPath(n, m, edges);
		for (int g : result) {
			System.out.print(g + " ");
		}

	}

	private static void topoSort(int node, ArrayList<ArrayList<Pair>> adjList, int[] vis, Stack<Integer> stack) {
		vis[node] = 1;
		for (int i = 0; i < adjList.get(node).size(); i++) {
			int v = adjList.get(node).get(i).first;

			if (vis[v] == 0) {
				topoSort(v, adjList, vis, stack);
			}
		}
		stack.add(node);
	}

	public static int[] shortestPath(int N, int M, int[][] edges) {
		ArrayList<ArrayList<Pair>> adjList = new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < N; i++) {
			ArrayList<Pair> temp = new ArrayList<Pair>();
			adjList.add(temp);
		}

		for (int i = 0; i < M; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int wt = edges[i][2];
			adjList.get(u).add(new Pair(v, wt));
		}

		int vis[] = new int[N];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < N; i++) {
			if (vis[i] == 0) {
				topoSort(i, adjList, vis, stack);
			}
		}

		// Initialize all the values of array as max
		int dist[] = new int[N];
		for (int i = 0; i < N; i++) {
			dist[i] = (int) (1e9);
		}

		// Initialize source node distance from itself as 0
		dist[0] = 0;
		while (!stack.isEmpty()) {
			int node = stack.peek();
			stack.pop();

			for (int i = 0; i < adjList.get(node).size(); i++) {
				int v = adjList.get(node).get(i).first;
				int wt = adjList.get(node).get(i).second;

				if (dist[node] + wt < dist[v]) {
					dist[v] = wt + dist[node];
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (dist[i] == 1e9)
				dist[i] = -1;
		}
		return dist;
	}

}
