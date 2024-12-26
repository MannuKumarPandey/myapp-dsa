package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedUnitWtGraphBFS {

	public static void main(String[] args) {
		int n = 9, m = 10;
		int edges[][] = { { 0, 1 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 1, 2 }, { 2, 6 }, { 6, 7 }, { 7, 8 },
				{ 6, 8 } };
		int srcNode = 0;
		int result[] = shortestPath(n, m, edges, srcNode);
		for (int g : result) {
			System.out.print(g + " ");
		}
	}

	private static int[] shortestPath(int N, int M, int[][] edges, int srcNode) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

		// Creating N number of empty arrayList in adjList
		for (int i = 0; i < N; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		// Adding those edges into list for undirected nature
		for (int i = 0; i < M; i++) {
			adjList.get(edges[i][0]).add(edges[i][1]);
			adjList.get(edges[i][1]).add(edges[i][0]);
		}

		int dist[] = new int[N];
		// Intialize distance array with huge value

		for (int i = 0; i < N; i++) {
			dist[i] = (int) 1e9;
		}

		// Now add the distance of source node from same as 0
		dist[0] = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(srcNode);

		while (!queue.isEmpty()) {
			int node = queue.peek();
			queue.remove();

			for (int curNode : adjList.get(node)) {
				if (dist[node] + 1 < dist[curNode]) {
					dist[curNode] = dist[node] + 1;
					queue.add(curNode);
				}
			}
		}
		// Initialize all the large values remaining in the dist[] as -1
		for (int i = 0; i < N; i++) {
			if (dist[i] == 1e9) {
				dist[i] = -1;
			}
		}
		return dist;
	}
}
