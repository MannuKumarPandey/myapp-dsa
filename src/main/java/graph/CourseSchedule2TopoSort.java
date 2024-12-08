package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2TopoSort {

	public static void main(String[] args) {
		int noOfVertices = 4;
		int[][] pairs = { { 1, 2 }, { 4, 3 }, { 2, 4 } };

		int[] array = isPossible(pairs, noOfVertices);
		for (int i = 1; i <= noOfVertices; i++) {
			System.out.print(array[i] + " ");
		}
	}
	public static int[] isPossible(int[][] pairs, int noOfVertices) {
		// For a graph
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

		// utane blank list add kijiye adjList me
		for (int i = 0; i <= noOfVertices; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		// Directed grapgh bnaiye

		int n = pairs.length;
		for (int i = 0; i < n; i++) {
			adjList.get(pairs[i][1]).add(pairs[i][0]);
		}

		// indegree array bnaiye
		int inDegree[] = new int[noOfVertices + 1];
		for (int i = 0; i <= noOfVertices; i++) {
			for (int curNode : adjList.get(i)) {
				inDegree[curNode]++;
			}
		}

		// maintain queue for BFS traversal
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i <= noOfVertices; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		// Iterate queue till it gets empty
		int topo[] = new int[noOfVertices + 1];
		int ind = 0;
		while (!queue.isEmpty()) {
			int node = queue.peek();
			queue.remove();
			topo[ind++] = node;

			// node is in your topo sort
			// so please remove it from indegree
			for (int curNode : adjList.get(node)) {
				inDegree[curNode]--;
				if (inDegree[curNode] == 0) {
					queue.add(curNode);
				}
			}
		}

		// agar toposort array ki size no of vertices ke barabar ho gayi matlab koi
		// cycle nahi mili hai
		// directed grapgh me and sare tasks complete kiye ja sakte hai

		if (ind == noOfVertices + 1) {
			return topo;
		} else {
			int arr[] = {};
			return arr;
		}
	}

}
