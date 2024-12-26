package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NoOfWaysToArriveAtDestination {

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
		int n = 7;
		ArrayList<ArrayList<Integer>> roads = new ArrayList<ArrayList<Integer>>() {
			{
				add(new ArrayList<Integer>(Arrays.asList(0, 6, 7)));
				add(new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
				add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
				add(new ArrayList<Integer>(Arrays.asList(1, 3, 3)));
				add(new ArrayList<Integer>(Arrays.asList(6, 3, 3)));
				add(new ArrayList<Integer>(Arrays.asList(3, 5, 1)));
				add(new ArrayList<Integer>(Arrays.asList(6, 5, 1)));
				add(new ArrayList<Integer>(Arrays.asList(2, 5, 1)));
				add(new ArrayList<Integer>(Arrays.asList(0, 4, 5)));
				add(new ArrayList<Integer>(Arrays.asList(4, 6, 2)));

			}
		};

		System.out.print(countPaths(n, roads));

		System.out.println();
	}

	private static int countPaths(int n, ArrayList<ArrayList<Integer>> roads) {

		// creating an adjacency list for the given graph
		ArrayList<ArrayList<Pair>> adjList = new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<Pair>());
		}

		int m = roads.size();
		for (int i = 0; i < m; i++) {
			adjList.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), roads.get(i).get(2)));
			adjList.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
		}

		// Defining a priority queue (Min Heap)
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first);

		// initializing the distance array and ways array
		// along with their first indices

		int[] dist = new int[n];
		int ways[] = new int[n];

		for (int i = 0; i < n; i++) {
			dist[i] = (int) 1e9;
			ways[i] = 0;
		}

		dist[0] = 0;
		ways[0] = 1;

		pq.add(new Pair(0, 0));

		// Define modulo value
		int mod = (int) (1e9 + 7);

		// Iterate through the graph with the help of priority queue
		// just as we do in Dijkstra's Algorithm.

		while (pq.size() != 0) {
			int dis = pq.peek().first;
			int node = pq.peek().second;

			pq.remove();

			for (Pair it : adjList.get(node)) {
				int adjNode = it.first;
				int edgeWeight = it.second;

				// This ‘if’ condition signifies that this is the first
				// time we’re coming with this short distance, so we push
				// in PQ and keep the no. of ways the same.

				if (dis + edgeWeight < dist[adjNode]) {
					dist[adjNode] = dis + edgeWeight;
					pq.add(new Pair(dis + edgeWeight, adjNode));
					ways[adjNode] = ways[node];
				}
				// If we again encounter a node with the same short distance
				// as before, we simply increment the no. of ways.

				else if (dis + edgeWeight == dist[adjNode]) {
					ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
				}

			}
		}
		// Finally, we return the no. of ways to reach
		// (n-1)th node modulo 10^9+7.
		return ways[n - 1] % mod;

	}
}
