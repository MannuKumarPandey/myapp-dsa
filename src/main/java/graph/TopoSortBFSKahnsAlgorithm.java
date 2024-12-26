package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSortBFSKahnsAlgorithm {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adjList = getDUWGraphAdjList();
		int[] topoSort = topoSort(adjList, 6);
		for (int dd : topoSort) {
			System.out.print(dd + " ");
		}

	}

	private static int[] topoSort(ArrayList<ArrayList<Integer>> adjList, int noOfVertex) {
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
		while (!queue.isEmpty()) {
			int node = queue.peek();
			queue.remove();
			topo[i++] = node;

			// node is in your topo sort
			// so please remove it from the indegree

			for (int curNode : adjList.get(node)) {
				inDegree[curNode]--;
				if (inDegree[curNode] == 0) {
					queue.add(curNode);
				}
			}
		}
		return topo;
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
