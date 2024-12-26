package trie;

import java.util.ArrayList;
import java.util.*;

public class MaxXorQuery {
	public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
		Collections.sort(arr);
		ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<ArrayList<Integer>>();
		int m = queries.size();
		for (int i = 0; i < m; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(queries.get(i).get(1));
			temp.add(queries.get(i).get(0));
			temp.add(i);
			offlineQueries.add(temp);
		}
		Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				return a.get(0).compareTo(b.get(0));
			}
		});
		int ind = 0;
		int n = arr.size();
		Trie7 trie = new Trie7();
		ArrayList<Integer> ans = new ArrayList<Integer>(m);
		for (int i = 0; i < m; i++)
			ans.add(-1);
		for (int i = 0; i < m; i++) {
			while (ind < n && arr.get(ind) <= offlineQueries.get(i).get(0)) {
				trie.insert(arr.get(ind));
				ind++;
			}
			int queryInd = offlineQueries.get(i).get(2);
			if (ind != 0)
				ans.set(queryInd, trie.getMax(offlineQueries.get(i).get(1)));
			else
				ans.set(queryInd, -1);
		}
		return ans;
	}
}

class Node7 {
	Node7 links[] = new Node7[2];

	public Node7() {
	}

	boolean containsKey(int ind) {
		return (links[ind] != null);
	}

	Node7 get(int ind) {
		return links[ind];
	}

	void put(int ind, Node7 node) {
		links[ind] = node;
	}
};

class Trie7 {
	private static Node7 root;

	// Initialize your data structure here

	Trie7() {
		root = new Node7();
	}

	// Inserts a word into the trie

	public static void insert(int num) {
		Node7 node = root;
		for (int i = 31; i >= 0; i--) {
			int bit = (num >> i) & 1;
			if (!node.containsKey(bit)) {
				node.put(bit, new Node7());
			}
			node = node.get(bit);
		}
	}

	public int getMax(int num) {
		Node7 node = root;
		int maxNum = 0;
		for (int i = 31; i >= 0; i--) {
			int bit = (num >> i) & 1;
			if (node.containsKey(1 - bit)) {
				maxNum = maxNum | (1 << i);
				node = node.get(1 - bit);
			} else {
				node = node.get(bit);
			}
		}
		return maxNum;
	}
};
