package trie;

public class TriePrefix1 {
    /**
     * Initialize your data structure here.
     */

    TrieNode root;

    public TriePrefix1() {

        root = new TrieNode();

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        TrieNode crwal = root;

        int index;

        for (int i = 0; i < word.length(); i++) {

            index = word.charAt(i) - 'a';

            if (crwal.children[index] == null) {
                crwal.children[index] = new TrieNode();
            }

            crwal.children[index].counter++;
            crwal = crwal.children[index];
        }

        crwal.endOfWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {


        int index;
        TrieNode crwal = root;

        for (int i = 0; i < word.length(); i++) {

            index = word.charAt(i) - 'a';

            if (crwal.children[index] == null) return false;

            crwal = crwal.children[index];
        }

        return (crwal != null && crwal.endOfWord);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

        int index;
        TrieNode crwal = root;

        for (int i = 0; i < prefix.length(); i++) {

            index = prefix.charAt(i) - 'a';

            if (crwal.children[index] == null) return false;

            crwal = crwal.children[index];
        }

        return (crwal != null && crwal.counter >= 1);
    }

    public static class TrieNode {
        //Set<TrieNode> children = new HashSet<>();
        TrieNode[] children = new TrieNode[26];
        int counter;
        boolean endOfWord;

        public TrieNode() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            endOfWord = false;
            counter = 0;
        }
    }

}
