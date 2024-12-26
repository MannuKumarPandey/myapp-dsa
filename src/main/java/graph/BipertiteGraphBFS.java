package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipertiteGraphBFS {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adjList = getUDUWGraphAdjList();
		System.out.println(isBipertiteGraph(adjList, 8));

	}

	private static boolean isBipertiteGraph(ArrayList<ArrayList<Integer>> adjList, int noOfVertex) {
		int[] color = new int[noOfVertex];
        Arrays.fill(color, -1);

		for (int i = 0; i < noOfVertex; i++) {
			if (color[i] == -1) {
				if (!check(i, noOfVertex, adjList, color)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean check(int start, int noOfVertex, ArrayList<ArrayList<Integer>> adjList, int[] color) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		color[start] = 0;

		while (!queue.isEmpty()) {
			int node = queue.peek();
			queue.remove();

			for (int hh : adjList.get(node)) {
				if (color[hh] == -1) {
					queue.add(hh);
					color[hh] = 1 - color[node];
				} else if (color[hh] == color[node]) {
					return false;
				}
			}

		}
		return true;

	}

	public static ArrayList<ArrayList<Integer>> getUDUWGraphAdjList() {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int n = 8;
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<Integer>());

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(2).add(6);
		adj.get(6).add(2);

		adj.get(2).add(3);
		adj.get(3).add(2);

		adj.get(3).add(4);
		adj.get(4).add(3);

		adj.get(6).add(5);
		adj.get(5).add(6);

		adj.get(4).add(5);
		adj.get(5).add(4);

		adj.get(4).add(7);
		adj.get(7).add(4);

		adj.get(7).add(8);
		adj.get(8).add(7);

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
