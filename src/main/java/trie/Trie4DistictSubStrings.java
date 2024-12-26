package trie;

public class Trie4DistictSubStrings {
	public static void main(String[] args) {

		String s1 = "abab";
		System.out.println("Total number of distinct substrings : " + countDistinctSubstrings(s1));

		String s2 = "ccfdf";
		System.out.println("Total number of distinct substrings : " + countDistinctSubstrings(s2));

	}

	public static int countDistinctSubstrings(String s) {
		Node root = new Node();
		int n = s.length();
		int count = 0;

		for (int i = 0; i < n; i++) {
			Node node = root;

			for (int j = i; j < n; j++) {
				if (!node.containsKey(s.charAt(j))) {
					node.put(s.charAt(j), new Node());
					count++;
				}
				node = node.get(s.charAt(j));
			}
		}
		return count + 1;
	}
}

class Trie4kaNode {
	Trie4kaNode links[] = new Trie4kaNode[26];

	boolean containsKey(char ch) {
		return (links[ch - 'a'] != null);
	}

	Trie4kaNode get(char ch) {
		return links[ch - 'a'];
	}

	void put(char ch, Trie4kaNode node) {
		links[ch - 'a'] = node;
	}
};
