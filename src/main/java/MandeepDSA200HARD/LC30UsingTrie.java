package MandeepDSA200HARD;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC30UsingTrie {

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}).toString());
    }

    public static void insertToTrie(Node root, String word) {

        Node curr = root;

        for (char c : word.toCharArray()) {

            if (curr.child[c - 'a'] == null) {
                curr.child[c - 'a'] = new Node();
            }

            curr = curr.child[c - 'a'];

        }
        curr.key = word;
        curr.index++;

    }

    public static List<Integer> findSubstring(String s, String[] words) {
        Node root = new Node();

        for (String word : words) {
            insertToTrie(root, word);
        }


        int n = s.length();

        int target = words.length;

        int wordLength = words[0].length();

        List<Integer> ans = new LinkedList();

        for (int i = 0; i <= n - target * wordLength; i++) {
            if (backtrack(i, s, root, root, new HashMap<String, Integer>(), target, 0))
                ans.add(i);
        }
        return ans;

    }

    public static boolean backtrack(int currIndex, String s, Node root, Node curr, HashMap<String, Integer> exploredIndices, int target, int count) {
        if (count == target)
            return true;
        if (currIndex == s.length())
            return false;
        char c = s.charAt(currIndex);
        if (curr.child[c - 'a'] == null)
            return false;
        if (curr.child[c - 'a'].key.length() != 0 && exploredIndices.getOrDefault(curr.child[c - 'a'].key, 0) < curr.child[c - 'a'].index) {
            exploredIndices.put(curr.child[c - 'a'].key,
                    exploredIndices.getOrDefault(curr.child[c - 'a'].key, 0) + 1);
            if (backtrack(currIndex + 1, s, root, root, exploredIndices, target, count + 1))
                return true;
            //  exploredIndices.put(curr.child[c-'a'].key,
            //  exploredIndices.get(curr.child[c-'a'].key)-1);
        }
        return backtrack(currIndex + 1, s, root, curr.child[c - 'a'], exploredIndices, target, count);

    }

    public static class Node {
        Node[] child;
        String key;
        int index;

        public Node() {
            child = new Node[26];
            key = "";
            index = 0;
        }
    }


}
