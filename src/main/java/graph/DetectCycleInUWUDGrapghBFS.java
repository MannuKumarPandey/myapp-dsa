package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUWUDGrapghBFS {

	private static class Pair {
		int node;
		int parentNode;

		public Pair(int node, int parentNode) {
			super();
			this.node = node;
			this.parentNode = parentNode;
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adjList = getUDUWGraphAdjList();
		PrintUDUWGraph(getUDUWGraphAdjList(), 7);
		boolean vis[] = new boolean[8];
		System.out.println(checkForCycle(adjList, 1, 7, vis));
	}

	private static boolean checkForCycle(ArrayList<ArrayList<Integer>> adjList, int source, int noOfVertices,
			boolean[] vis) {

		vis[source] = true;
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(source, -1));

		while (!queue.isEmpty()) {
			int node = queue.peek().node;
			int parentNode = queue.peek().parentNode;
			queue.remove();

			for (int adjNode : adjList.get(node)) {
				if (vis[adjNode] == false) {
					vis[adjNode] = true;
					queue.add(new Pair(adjNode, node));
				} else if (parentNode != adjNode) { // nahi to pahle se hi visited hai wo node tab
					return true;
				}
			}
		}
		return false;

	}

	public static ArrayList<ArrayList<Integer>> getUDUWGraphAdjList() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int n = 7;
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(1).add(3);
		adj.get(3).add(1);

		adj.get(2).add(5);
		adj.get(5).add(2);

		adj.get(3).add(4);
		adj.get(4).add(3);

		adj.get(3).add(6);
		adj.get(6).add(3);

		adj.get(6).add(7);
		adj.get(7).add(6);

		adj.get(7).add(5);
		adj.get(5).add(7);

		return adj;
	}

	public static void PrintUDUWGraph(ArrayList<ArrayList<Integer>> adjList, int n) {
		for (int i = 1; i <= n; i++) {
			System.out.print(i + " is connected to ");
			for (int j = 0; j < adjList.get(i).size(); j++) {
				System.out.print(adjList.get(i).get(j) + "  ");
			}
			System.out.println();
		}
	}
}
