package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

	private static class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
	}

	private static class Tuple {
		int first;
		int second;
		int third;

		public Tuple(int first, int second, int third) {
			super();
			this.first = first;
			this.second = second;
			this.third = third;
		}
	}

	public static void main(String[] args) {
		int n = 4, src = 0, dst = 3, K = 1;
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
		System.out.print(cheapestFlight(n, flights, src, dst, K));
	}

	public static int cheapestFlight(int n, int flights[][], int src, int dest, int K) {

		// create the adjacancey list to depict the airports and flights in the form of
		// graph

		ArrayList<ArrayList<Pair>> adjList = new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<Pair>());
		}

		int m = flights.length;
		for (int i = 0; i < m; i++) {
			adjList.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
		}

		// create a queue which stores the node and their distances from the
		// source in the form of stops, node , dist, with stops indicating
		// the no. of nodes between src to current node

		Queue<Tuple> q = new LinkedList<>();
		q.add(new Tuple(0, src, 0));

		// Distance array to store the updated distances from the source.
		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = (int) (1e9);
		}
		dist[src] = 0;

		// Iterate through the graph using a queue like in Dijkstra with
		// popping out the element with min stops first.
		while (!q.isEmpty()) {
			Tuple it = q.peek();
			q.remove();
			int stops = it.first;
			int node = it.second;
			int cost = it.third;

			// We stop the process as soon as the limit for the stops reaches.
			if (stops > K)
				continue;
			for (Pair iter : adjList.get(node)) {
				int adjNode = iter.first;
				int edW = iter.second;

				// We only update the queue if the new calculated dist is
				// less than the prev and the stops are also within limits.
				if (cost + edW < dist[adjNode] && stops <= K) {
					dist[adjNode] = cost + edW;
					q.add(new Tuple(stops + 1, adjNode, cost + edW));
				}
			}
		}
		// If the destination node is unreachable return ‘-1’
		// else return the calculated dist from src to dst.
		if (dist[dest] == (int) (1e9))
			return -1;
		return dist[dest];
	}
}
