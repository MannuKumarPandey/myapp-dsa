package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TasksSchedule1TopoSortBFS {

	public static void main(String[] args) {
		int noOfVertices = 4;
		int[][] pairs = { { 1, 2 }, { 4, 3 }, { 2, 4 }, { 4, 1 } };

		System.out.println(isPossible(pairs, noOfVertices));

	}

	public static boolean isPossible(int[][] pairs, int noOfVertices) {
		// For a graph
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		
		//utane black list add kijiye adjList me 
		for (int i = 0; i <= noOfVertices; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		//Directed grapgh bnaiye
		
		int n = pairs.length;
		for (int i = 0; i < n; i++) {
			adjList.get(pairs[i][0]).add(pairs[i][1]);
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
		List<Integer> topo = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			int node = queue.peek();
			queue.remove();
			topo.add(node);

			// node is in your topo sort
			// so please remove it from indegree
			for (int curNode : adjList.get(node)) {
				inDegree[curNode]--;
				if (inDegree[curNode] == 0) {
					queue.add(curNode);
				}
			}
		}

		// agar toposort array ki size no of vertices ke barabar ho gayi matlab koi cycle nahi mili hai 
		// directed grapgh me and sare tasks complete kiye ja sakte hai 
		
		if (topo.size() == noOfVertices) {
			return true;
		} else {
			return false;
		}
	}
}
