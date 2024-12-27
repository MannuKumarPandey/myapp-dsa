package trie;

public class MainTrieImplementationPrefixSearch {
    public static void main(String[] args) {
        TrieNode t1 = new TrieNode();

        t1.insert("abc");
        t1.insert("b");
        t1.insert("c");
        t1.insert("d");
        t1.insert("e");
        t1.insert("f");
        t1.insert("g");
        t1.insert("h");
        t1.insert("i");
        t1.insert("j");
        t1.insert("k");
        t1.insert("l");
        t1.insert("m");
        t1.insert("n");
        t1.insert("o");
        t1.insert("p");
        t1.insert("q");
        t1.insert("r");
        t1.insert("s");
        t1.insert("t");
        t1.insert("u");
        t1.insert("v");
        t1.insert("w");
        t1.insert("x");
        t1.insert("y");
        t1.insert("z");

        System.out.println(t1);
        System.out.println(t1.wordSearch("x"));
        System.out.println(t1.prefixSearch("t"));
    }

}

class TrieNode {
    TrieNode[] tries; //actul starting point hia tries ke isi object se
    boolean endStatus;

    public TrieNode() {
        tries = new TrieNode[26];
        endStatus = false;
    }

    public void insert(String word) {
        TrieNode temp = this;
        // same class ke object ko refer karne ke liye
        //temporary helper bana rahe hai jo hame
        int wordLength = word.length();

        for (int i = 0; i < wordLength; i++) {
            int index = word.charAt(i) - 'a';
            if (temp.tries[index] == null) {
                temp.tries[index] = new TrieNode();
                // ham sirf object isliye bana rahe hai ki hamara wo index null na rahe
                // jo index null nahi hai aur wo TrieNode ka object rakhahai matlab wha wo character thi string me
            }
            //temp = temp.next ki tarah jaaisa linked list ke traversal me lagata hia
            temp = temp.tries[index];
        }

        temp.endStatus = true;
    }

    public boolean wordSearch(String word) {
        TrieNode temp = this;
        int wordLength = word.length();

        for (int i = 0; i < wordLength; i++) {
            int index = word.charAt(i) - 'a';

            if (tries[index] == null) {
                return false;
            }
            temp = temp.tries[index];
        }
        return temp.endStatus;

    }

    public boolean prefixSearch(String prefix) {
        TrieNode temp = this;

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

    public boolean delete(String word) {
        return deleteHelper(this, word, 0);
    }

    private boolean deleteHelper(TrieNode node, String word, int depth) {
        if (node == null) {
            return false;
        }

        // If last character of the word is reached
        if (depth == word.length()) {
            // This node is no longer the end of a word
            if (node.endStatus) {
                node.endStatus = false;
            }
            // If the node has no children, it can be deleted
            return node.isEmpty();
        }

        int index = word.charAt(depth) - 'a';
        if (deleteHelper(node.tries[index], word, depth + 1)) {
            // Delete the child node if it is empty
            node.tries[index] = null;

            // Return true if the current node is not the end of another word and has no children
            return !node.endStatus && node.isEmpty();
        }

        return false;
    }

    public boolean isEmpty() {
        //checking for all teh indexes , is there any index which is having the object of Trie Node or not
        for (int i = 0; i < 26; i++) {
            if (tries[i] != null) {
                return false;
            }
        }
        return true;
    }
}















