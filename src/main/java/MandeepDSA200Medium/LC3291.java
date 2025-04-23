package MandeepDSA200Medium;

import java.util.Arrays;

class LC3291 {

    public static void main(String[] args) {
        System.out.println(minValidStrings(new String[]{"abc", "aaaaa", "bcdef"}, "aabcdabc"));
    }

    public static int minValidStrings(String[] words, String target) {
        Trie t = new Trie();
        for (String i : words) t.insert(i);// Insert all valid words into a Trie.

        int[] memo = new int[target.length()];// Initialize memoization array.
        Arrays.fill(memo, -1);

        int ans = solve(t, target, 0, memo);// Try to build target from index 0
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    //The Core DP + DFS Logic
    public static int solve(Trie t, String target, int index, int[] memo) {
        if (index == target.length()) return 0;// Base case: whole target matched
        if (memo[index] != -1) return memo[index];// Already computed

        int minValue = Integer.MAX_VALUE;
        Node curr = t.root;//temporary object for the traversal

        for (int i = index; i < target.length(); i++) {
            int ch = target.charAt(i) - 'a';
            if (curr.child[ch] == null) break;// No matching word prefix
            curr = curr.child[ch];
            if (curr != null) {
                // At this point, target.substring(index, i+1) is a valid prefix
                int result = solve(t, target, i + 1, memo);
                if (result != Integer.MAX_VALUE) {
                    minValue = Math.min(minValue, 1 + result);
                }
            }
        }

        return memo[index] = minValue;// Store result for future
    }
}
class Node {
    Node[] child;
    Node() {
        child = new Node[26];
    }
}

class Trie {
    Node root;
    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node c = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (c.child[index] == null) c.child[index] = new Node();
            c = c.child[index];
        }
    }

    public boolean search(String s) {
        Node c = root;
        for (char i : s.toCharArray()) {
            if (c.child[i - 'a'] == null) return false;
            c = c.child[i - 'a'];
        }
        return true;
    }
}
