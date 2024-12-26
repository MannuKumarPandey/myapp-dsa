package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
	public static void main(String[] args) {
		String[] dictionary = { "baa", "abcd", "abca", "cab", "cad" };
		int N = 5;
		int K = 4;

		System.out.println(findOrder(dictionary, N, K));
	}

	public static String findOrder(String[] dictionary, int N, int K) {

		// prepare graph
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < K; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < N - 1; i++) { // N-2 tak hi qki N-1 wale string se compare karne honge
			String s1 = dictionary[i];
			String s2 = dictionary[i + 1];

			int length = Math.min(s1.length(), s2.length());

			for (int j = 0; j < length; j++) {
				if (s1.charAt(j) != s2.charAt(j)) {
					adjList.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
					break;
				}
			}
		}
		List<Integer> topo = topo(K, adjList);
		StringBuilder ans = new StringBuilder();
		for (int curNode : topo) {
			ans.append((char) (curNode + (int) 'a'));
		}
		return ans.toString();
	}

	private static List<Integer> topo(int noOfVertices, ArrayList<ArrayList<Integer>> adjList) {
		// indegree array bnaiye
		int[] inDegree = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			for (int curNode : adjList.get(i)) {
				inDegree[curNode]++;
			}
		}

		// maintain queue for BFS traversal
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < noOfVertices; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		// Iterate queue till it gets empty
		ArrayList<Integer> topo = new ArrayList<Integer>();
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
		return topo;
	}
}
