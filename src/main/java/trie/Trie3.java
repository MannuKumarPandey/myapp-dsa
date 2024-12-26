package trie;

class Trie3KaNode {
	Trie3KaNode links[] = new Trie3KaNode[26];
	boolean flag = false;

	public Trie3KaNode() {

	}

	boolean containsKey(char ch) {
		return (links[ch - 'a'] != null);
	}

	Trie3KaNode get(char ch) {
		return links[ch - 'a'];
	}

	void put(char ch, Trie3KaNode node) {
		links[ch - 'a'] = node;
	}

	void setEnd() {
		flag = true;
	}

	boolean isEnd() {
		return flag;
	}
};

public class Trie3 {

	private static Trie3KaNode root;

	// Initialize your data structure here

	Trie3() {
		root = new Trie3KaNode();
	}

	// Inserts a word into the trie

	public static void insert(String word) {
		Trie3KaNode node = root;
		for (int i = 0; i < word.length(); i++) {
			if (!node.containsKey(word.charAt(i))) {
				node.put(word.charAt(i), new Trie3KaNode());
			}
			node = node.get(word.charAt(i));
		}
		node.setEnd();
	}

	static boolean checkIfAllPrefixExists(String word) {
		Trie3KaNode node = root;
		boolean flag = true;
		for (int i = 0; i < word.length() && flag; i++) {
			if (node.containsKey(word.charAt(i))) {
				node = node.get(word.charAt(i));
				flag = flag & node.isEnd();
			} else {
				return false;
			}
		}
		return flag;
	}

	static String completeString(int n, String[] a) {
		Trie3 obj = new Trie3();
		for (String word : a)
			obj.insert(word);
		String longest = "";
		for (String word : a) {
			if (obj.checkIfAllPrefixExists(word)) {
				if (word.length() > longest.length()) {
					longest = word;
				} else if (word.length() == longest.length() && word.compareTo(longest) == 1 ? false : true) {
					longest = word;
				}
			}
		}
		if (longest == "")
			return "None";
		return longest;
	}
}
