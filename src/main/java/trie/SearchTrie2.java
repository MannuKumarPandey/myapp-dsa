package trie;

import java.util.ArrayList;
import java.util.List;

public class SearchTrie2 {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("cats");
        al.add("dog");
        al.add("sand");
        al.add("and");
        al.add("cat");

        System.out.println(wordBreak("catsanddog", al));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        TrieImplementationAdvancedTrieNode t = new TrieImplementationAdvancedTrieNode();
        for (String curS : wordDict) {
            t.insert(curS);
        }

        return t.search(s);
    }
}

class Trie1 {
    Trie1[] tries;
    boolean endStatus;

    public Trie1() {
        tries = new Trie1[26];
        endStatus = false;
    }

    public void insert(String word) {
        Trie1 temp = this;
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            int index = word.charAt(i) - 'a';
            if (temp.tries[index] == null) {
                temp.tries[index] = new Trie1();
            }
            temp = temp.tries[index];
        }
        temp.endStatus = true;
    }

    public boolean search(String word) {
        boolean res = true;
        Trie1 temp = this;
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            int index = word.charAt(i) - 'a';
            if (temp.endStatus == true) {
                continue;
            }
            if (temp.tries[index] == null) {
                return false;
            }
            temp = temp.tries[index];
        }
        return temp.endStatus == true;
    }
}

