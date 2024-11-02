package trie;

public class TrieImplementation {
    public static void main(String[] args) {
        Trie5 t1 = new Trie5();
        t1.insert("hotdog");
        System.out.println(t1.search("dog"));
    }

}

class Trie5 {
    Trie5[] tries;
    boolean endStatus;

    public Trie5() {
        tries = new Trie5[26];
        endStatus = false;
    }

    public void insert(String word) {
        Trie5 temp = this;
        int wordLength = word.length();

        for (int i = 0; i < wordLength; i++) {
            int index = word.charAt(i) - 'a';
            if (temp.tries[index] == null) {
                temp.tries[index] = new Trie5();
            }
            temp = temp.tries[index];
        }

        temp.endStatus = true;
    }

    public boolean search(String word) {
        Trie5 temp = this;
        int wordLength = word.length();

        for (int i = 0; i < wordLength; i++) {
            int index = word.charAt(i) - 'a';

            if (tries[index] == null) {
                return false;
            }

            temp = temp.tries[index];
        }

        return temp.endStatus == true;

    }

    public boolean startsWith(String prefix) {
        Trie5 temp = this;

        int wordLength = prefix.length();

        for (int i = 0; i < wordLength; i++) {
            int index = prefix.charAt(i) - 'a';

            if (tries[index] == null) {
                return false;
            }

            temp = temp.tries[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */

