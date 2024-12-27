package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieImplementationPrefixSearchUsingHashMap {
    public static void main(String[] args) {
        TrieNodeUsingHM t1 = new TrieNodeUsingHM();

        t1.insert("abc", 1);
        t1.insert("b", 2);
        t1.insert("c", 3);
        t1.insert("d", 4);
        t1.insert("e", 5);

        System.out.println(t1.wordSearch("abc")); // true
        System.out.println(t1.wordSearch("x"));   // false
        System.out.println(t1.prefixSearch("a")); // true
        System.out.println(t1.delete("abc"));     // true
        System.out.println(t1.wordSearch("abc")); // false
    }
}

class TrieNodeUsingHM {
    Map<Integer, TrieNodeUsingHM> children; // Maps character indices to child nodes
    boolean endStatus;

    public TrieNodeUsingHM() {
        children = new HashMap<>();
        endStatus = false;
    }

    public void insert(String word, int id) {
        TrieNodeUsingHM temp = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            temp.children.putIfAbsent(index, new TrieNodeUsingHM());
            temp = temp.children.get(index);
        }
        temp.endStatus = true;
    }

    public boolean wordSearch(String word) {
        TrieNodeUsingHM temp = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (!temp.children.containsKey(index)) {
                return false;
            }
            temp = temp.children.get(index);
        }
        return temp.endStatus;
    }

    public boolean prefixSearch(String prefix) {
        TrieNodeUsingHM temp = this;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (!temp.children.containsKey(index)) {
                return false;
            }
            temp = temp.children.get(index);
        }
        return true;
    }

    public boolean delete(String word) {
        return deleteHelper(this, word, 0);
    }

    private boolean deleteHelper(TrieNodeUsingHM node, String word, int depth) {
        if (node == null) {
            return false;
        }

        // If the last character of the word is reached
        if (depth == word.length()) {
            if (node.endStatus) {
                node.endStatus = false;
            }
            // Return true if node has no children
            return node.children.isEmpty();
        }

        int index = word.charAt(depth) - 'a';
        TrieNodeUsingHM child = node.children.get(index);
        if (child == null) {
            return false;
        }

        boolean shouldDeleteChild = deleteHelper(child, word, depth + 1);

        if (shouldDeleteChild) {
            node.children.remove(index);
            return node.children.isEmpty() && !node.endStatus;
        }

        return false;
    }

    public boolean isEmpty() {
        return children.isEmpty();
    }
}
