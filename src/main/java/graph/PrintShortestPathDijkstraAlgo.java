package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PrintShortestPathDijkstraAlgo {

	private static class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) {
		int noOfVerteces = 5, noOfEdges = 6;

		// in each row of this edges array : souce node, destination node with edge
		// weight is kept.
		int[][] edges = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
		List<Integer> path = shortestPathDijkstraAlgo(noOfVerteces, noOfEdges, edges);
		for (int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i) + " ");
		}
		System.out.println();
	}

	private static List<Integer> shortestPathDijkstraAlgo(int n, int m, int edges[][]) {
		ArrayList<ArrayList<Pair>> adjList = new ArrayList<ArrayList<Pair>>();

		// Create blank n number of arraylist and add in the adjList.
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<Pair>());
		}

		// convert from 2D array to adjList
		for (int i = 0; i < m; i++) {
			adjList.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2])); // 0 , 1 with 2 index
			// means edges[][] array ke har ek row me start node end node and wt hai
			adjList.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2])); // 0 , 0 with 2 index
			// add in the same way for undirected graph
		}

		// create a priority queue
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first);
		// since created Priority queue is on custom class so adding the diffecrence
		// range as comparator

		// Create a dist array for storing the updated distances and a parent array
		// for storing the nodes from where the current nodes represented by indices of
		// the parent array came from.
		int[] dist = new int[n + 1];
		int[] parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dist[i] = (int) (1e9); // initialize dist array with very high value
			parent[i] = i; // parent array with the indexes
		}

		dist[1] = 0; // since 1 is the source node

		// push the source node to queue
		pq.add(new Pair(0, 1));

		while (!pq.isEmpty()) {

			// top most element of the priority queue is with the minimum distance value
			Pair it = pq.peek();
			int node = it.second;
			int distance = it.first;
			pq.remove();

			// Iterate through the adjacent nodes of the current popped node
			for (Pair curPair : adjList.get(node)) {
				int adjNode = curPair.first;
				int edgeWeight = curPair.second;

				// Check if the previously stored distance value is
				// greater than the current computed value or not,
				// if yes then update the distance value.
				if (distance + edgeWeight < dist[adjNode]) {
					dist[adjNode] = distance + edgeWeight;
					pq.add(new Pair(distance + edgeWeight, adjNode));

					// Update the parent of the adjNode to the recent
					// node where it came from.
					parent[adjNode] = node;
				}
			}
		}

		// Store the final path in the ‘path’ array.
		List<Integer> path = new ArrayList<>();

		// If distance to a node could not be found, return an array containing -1.
		if (dist[n] == 1e9) {
			path.add(-1);
			return path;
		}

		int node = n;
		// o(N)
		while (parent[node] != node) {
			path.add(node);
			node = parent[node];
		}
		path.add(1);

		// Since the path stored is in a reverse order, we reverse the array
		// to get the final answer and then return the array.
		Collections.reverse(path);
		return path;
	}
}
