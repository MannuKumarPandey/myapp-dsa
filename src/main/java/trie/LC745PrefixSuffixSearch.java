package trie;
import java.util.HashMap;
import java.util.Map;


public class LC745PrefixSuffixSearch {
    private static class TrieNode {
        TrieNode[] children;
        Map<String, Integer> indexMap; // Maps words to their index

        TrieNode() {
            children = new TrieNode[26];
            indexMap = new HashMap<>();
        }
    }

    private final TrieNode prefixRoot; // Root Trie for prefix
    private final TrieNode suffixRoot; // Root Trie for suffix

    public LC745PrefixSuffixSearch(String[] words) {
        prefixRoot = new TrieNode();
        suffixRoot = new TrieNode();

        // Insert all words into both prefix and suffix Tries
        for (int index = 0; index < words.length; index++) {
            insert(prefixRoot, words[index], index, false); // Prefix Trie
            insert(suffixRoot, new StringBuilder(words[index]).reverse().toString(), index, true); // Suffix Trie
        }
    }

    private void insert(TrieNode root, String word, int weight, boolean isReversed) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            // Store the weight for this word in the current node
            String originalWord = isReversed ? new StringBuilder(word).reverse().toString() : word;
            node.indexMap.put(originalWord, weight);
        }
    }

    public int f(String prefix, String suffix) {
        // Get all words matching the prefix
        Map<String, Integer> prefixMatches = search(prefixRoot, prefix, false);
        // Get all words matching the reversed suffix
        Map<String, Integer> suffixMatches = search(suffixRoot, new StringBuilder(suffix).reverse().toString(), true);

        // Find the maximum weight word that exists in both prefix and suffix matches
        int maxWeight = -1;
        for (String word : prefixMatches.keySet()) {
            if (suffixMatches.containsKey(word)) {
                maxWeight = Math.max(maxWeight, prefixMatches.get(word));
            }
        }

        return maxWeight;
    }

    private Map<String, Integer> search(TrieNode root, String query, boolean isReversed) {
        TrieNode node = root;
        for (char ch : query.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return new HashMap<>(); // No matches found
            }
            node = node.children[index];
        }
        return node.indexMap;
    }

    public static void main(String[] args) {
        // Example usage
        LC745PrefixSuffixSearch wordFilter = new LC745PrefixSuffixSearch(new String[]{"apple", "ape", "apricot", "banana"});
        System.out.println(wordFilter.f("ap", "le")); // Output: 0 (apple)
        System.out.println(wordFilter.f("ap", "e"));  // Output: 1 (ape)
        System.out.println(wordFilter.f("b", "a"));   // Output: 3 (banana)
    }
}
