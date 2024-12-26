package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGrapghBFSKahnsAlgo {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adjList = getDUWGraphAdjList();
		System.out.println(topoSort(adjList, 6));
	}

	private static boolean topoSort(ArrayList<ArrayList<Integer>> adjList, int noOfVertex) {
		int inDegree[] = new int[noOfVertex];

		// Preparing the indegree array with the help of number of adjacencny nodes in
		// list
		for (int i = 0; i < noOfVertex; i++) {
			for (int curNode : adjList.get(i)) {
				inDegree[curNode]++;
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < noOfVertex; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		int topo[] = new int[noOfVertex];
		int i = 0;
		int count = 0;
		while (!queue.isEmpty()) {
			int node = queue.peek();
			queue.remove();

			count++;

			// node is in your topo sort
			// so please remove it from the indegree

			for (int curNode : adjList.get(node)) {
				inDegree[curNode]--;
				if (inDegree[curNode] == 0) {
					queue.add(curNode);
				}
			}
		}
		if (count == noOfVertex) {
			return false;
		}
		return true;
	}

	public static ArrayList<ArrayList<Integer>> getDUWGraphAdjList() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int n = 5;
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(1).add(2);

		adj.get(2).add(3);

		adj.get(3).add(4);
		adj.get(4).add(2);

		adj.get(3).add(5);

		return adj;
	}
}
