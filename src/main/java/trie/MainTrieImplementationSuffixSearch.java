package trie;

public class MainTrieImplementationSuffixSearch {

    public static void main(String[] args) {
        SuffixTrieNode trie = new SuffixTrieNode();

        // Insert words into the Trie
        trie.insert("abc");
        trie.insert("bcd");
        trie.insert("xyz");

        // Word search
        System.out.println(trie.wordSearch("abc")); // true
        System.out.println(trie.wordSearch("bcd")); // true
        System.out.println(trie.wordSearch("abcd")); // false

        // Suffix search
        System.out.println(trie.suffixSearch("bc")); // true
        System.out.println(trie.suffixSearch("yz")); // true
        System.out.println(trie.suffixSearch("abcd")); // false

        // Delete a word
        trie.delete("xyz");
        System.out.println(trie.suffixSearch("yz")); // false

        // Check if Trie is empty
        System.out.println(trie.isEmpty()); // false

        // Delete remaining words
        trie.delete("abc");
        trie.delete("bcd");
        System.out.println(trie.isEmpty()); // true
    }
}

class SuffixTrieNode {
    SuffixTrieNode[] tries; // Children nodes
    boolean endStatus;      // Marks the end of a word

    public SuffixTrieNode() {
        tries = new SuffixTrieNode[26];
        endStatus = false;
    }

    // Insert a word into the Trie in reverse order
    public void insert(String word) {
        SuffixTrieNode temp = this;
        int wordLength = word.length();

        for (int i = wordLength - 1; i >= 0; i--) { // Reverse order
            int index = word.charAt(i) - 'a';
            if (temp.tries[index] == null) {
                temp.tries[index] = new SuffixTrieNode();
            }
            temp = temp.tries[index];
        }

        temp.endStatus = true;
    }

    // Search for an exact word in the Trie
    public boolean wordSearch(String word) {
        SuffixTrieNode temp = this;
        int wordLength = word.length();

        for (int i = wordLength - 1; i >= 0; i--) { // Reverse order
            int index = word.charAt(i) - 'a';

            if (temp.tries[index] == null) {
                return false;
            }
            temp = temp.tries[index];
        }
        return temp.endStatus;
    }


    // Search for a suffix in the Trie
    public boolean suffixSearch(String suffix) {
        SuffixTrieNode temp = this;
        int wordLength = suffix.length();

        for (int i = wordLength - 1; i >= 0; i--) { // Reverse order
            int index = suffix.charAt(i) - 'a';

            if (temp.tries[index] == null) {
                return false;
            }
            temp = temp.tries[index];
        }
        return true;
    }

    // Delete a word from the Trie
    public boolean delete(String word) {
        return deleteHelper(this, word, word.length() - 1);
    }

    private boolean deleteHelper(SuffixTrieNode node, String word, int depth) {
        if (node == null) {
            return false;
        }

        // If last character of the word is reached
        if (depth < 0) {
            // Mark this node as not an end of a word
            if (node.endStatus) {
                node.endStatus = false;
            }

            // If the node has no children, it can be deleted
            return node.isEmpty();
        }

        int index = word.charAt(depth) - 'a';
        if (deleteHelper(node.tries[index], word, depth - 1)) {
            // Delete the child node if it is empty
            node.tries[index] = null;

            // Return true if the current node is not the end of another word and has no children
            return !node.endStatus && node.isEmpty();
        }

        return false;
    }

    // Check if the Trie is empty
    public boolean isEmpty() {
        for (int i = 0; i < 26; i++) {
            if (tries[i] != null) {
                return false;
            }
        }
        return true;
    }
}
