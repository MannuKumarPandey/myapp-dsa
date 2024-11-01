package trie;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxXor {
	public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		Trie5 trie = new Trie5();
		for (int i = 0; i < n; i++) {
			trie.insert(arr1.get(i));
		}
		int maxi = 0;
		for (int i = 0; i < m; i++) {
			maxi = Math.max(maxi, trie.getMax(arr2.get(i)));
		}
		return maxi;
	}

	public static void main(String[] args) {
		int n = 2, m = 3;
		ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(new Integer[] { 6, 8 }));
		ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(new Integer[] { 7, 8, 2 }));

		System.out.println(maxXOR(n, m, arr1, arr2));
	}
}

class Node5 {
	Node5 links[] = new Node5[2];

	public Node5() {
	}

	boolean containsKey(int ind) {
		return (links[ind] != null);
	}

	Node5 get(int ind) {
		return links[ind];
	}

	void put(int ind, Node5 node) {
		links[ind] = node;
	}
};

class Trie5 {
	private static Node5 root;

	// Initialize your data structure here
	Trie5() {
		root = new Node5();
	}

	// Inserts a word into the trie
	public static void insert(int num) {
		Node5 node = root;
		for (int i = 31; i >= 0; i--) {
			int bit = (num >> i) & 1;
			if (!node.containsKey(bit)) {
				node.put(bit, new Node5());
			}
			node = node.get(bit);
		}
	}

	public int getMax(int num) {
		Node5 node = root;
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