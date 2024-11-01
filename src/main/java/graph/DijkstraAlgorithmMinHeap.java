package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithmMinHeap {

	private static class Pair {

		int node;
		int distance;

		public Pair(int distance, int node) {
			super();
			this.node = node;
			this.distance = distance;
		}
	}

	public static void main(String[] args) {
		int noOfVerteces = 3;
		int noOfEdges = 3;
		int souceNode = 2;

		ArrayList<Integer> node1 = new ArrayList<Integer>() {
			{
				add(1);
				add(1);
			}
		}; // connect 0 to 1 with 1 weight
		ArrayList<Integer> node2 = new ArrayList<Integer>() {
			{
				add(2);
				add(6);
			}
		}; // 0 to 2 with 6 weight
		ArrayList<Integer> node3 = new ArrayList<Integer>() {
			{
				add(2);
				add(3);
			}
		}; // 1 to 2 with 3 wt
		ArrayList<Integer> node4 = new ArrayList<Integer>() {
			{
				add(0);
				add(1);
			}
		}; // 1 to 0 with 1 wt
		ArrayList<Integer> node5 = new ArrayList<Integer>() {
			{
				add(1);
				add(3);
			}
		}; // 2 to 1 with 3 wt
		ArrayList<Integer> node6 = new ArrayList<Integer>() {
			{
				add(0);
				add(6);
			}
		}; // 2 to 0 with 6 wt

		ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>() {
			{
				add(node1);
				add(node2);

			}
		};

		ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>() {
			{
				add(node3);
				add(node4);

			}
		};

		ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>() {
			{
				add(node5);
				add(node6);

			}
		};

		// adjList
		ArrayList<ArrayList<ArrayList<Integer>>> adjList = new ArrayList<ArrayList<ArrayList<Integer>>>() {
			{
				add(inter1); // for 1st node
				add(inter2); // for 2nd node
				add(inter3); // for 3rd node
			}
		};

		int[] res = dijkstraAlgo(noOfVerteces, adjList, souceNode);
		for (int g : res) {
			System.out.print(g + " ");
		}

	}

	private static int[] dijkstraAlgo(int V, ArrayList<ArrayList<ArrayList<Integer>>> adjList, int sourceNode) {

		// min heap
		PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

		int[] dist = new int[V];
		for (int i = 0; i < V; i++) {
			dist[i] = (int) 1e9;
		}

		dist[sourceNode] = 0;
		minHeap.add(new Pair(0, sourceNode));

		// Now, pop the minimum distance node first from the min-heap
		// and traverse for all its adjacent nodes.
		while (minHeap.size() != 0) {
			int dis = minHeap.peek().distance;
			int node = minHeap.peek().node;
			minHeap.remove();

			// Check for all adjacent nodes of the popped out
			// element whether the prev dist is larger than current or not.
			for (int i = 0; i < adjList.get(node).size(); i++) {
				int edgeWeight = adjList.get(node).get(i).get(1);
				int adjNode = adjList.get(node).get(i).get(0);

				// If current distance is smaller,
				// push it into the queue.
				if (dis + edgeWeight < dist[adjNode]) {
					dist[adjNode] = dis + edgeWeight;
					minHeap.add(new Pair(dist[adjNode], adjNode));
				}
			}
		}
		return dist;
	}

}
