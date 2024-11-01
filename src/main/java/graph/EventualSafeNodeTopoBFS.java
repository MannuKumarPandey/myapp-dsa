package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeNodeTopoBFS {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adjList = getDUWGraphAdjList();
		List<Integer> list = eventualSafeNode(adjList, 11);
		for (int dd : list) {
			System.out.print(dd + " ");
		}

	}

	private static List<Integer> eventualSafeNode(ArrayList<ArrayList<Integer>> adjList, int noOfVertex) {

		// create reversed edges adjList from given list
		ArrayList<ArrayList<Integer>> adjListReversed = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= noOfVertex; i++) {
			adjListReversed.add(new ArrayList<Integer>());
		}

		// create indegree array
		int inDegree[] = new int[noOfVertex + 1];

		for (int i = 0; i <= noOfVertex; i++) {
			for (int curNode : adjList.get(i)) {
				adjListReversed.get(curNode).add(i);
				inDegree[i]++;
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> safeNodes = new ArrayList<Integer>();
		for (int i = 0; i <= noOfVertex; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int node = queue.peek();
			queue.remove();
			safeNodes.add(node);

			for (int curNode : adjListReversed.get(node)) {
				inDegree[curNode]--;
				if (inDegree[curNode] == 0) {
					queue.add(curNode);
				}
			}
		}
		Collections.sort(safeNodes);
		return safeNodes;
	}

	public static ArrayList<ArrayList<Integer>> getDUWGraphAdjList() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int n = 11;
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(0).add(1);

		adj.get(1).add(2);

		adj.get(2).add(3);

		adj.get(3).add(4);
		adj.get(3).add(5);

		adj.get(4).add(6);
		adj.get(5).add(6);

		adj.get(6).add(7);

		adj.get(8).add(1);
		adj.get(8).add(9);

		adj.get(9).add(10);

		adj.get(10).add(8);
		adj.get(11).add(9);

		return adj;
	}

}
