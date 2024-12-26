package trie;

public class MainTrieImplementation {
    public static void main(String[] args) {
        Trie5 t1 = new Trie5();

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
        System.out.println(t1.search("x"));
    }

}

class Trie5 {
    Trie5[] tries; //actul starting point hia tries ke isi object se
    boolean endStatus;

    public Trie5() {
        tries = new Trie5[26];
        endStatus = false;
    }

    public void insert(String word) {
        Trie5 temp = this;
        // same class ke object ko refer karne ke liye
        //temporary helper bana rahe hai jo hame
        int wordLength = word.length();

        for (int i = 0; i < wordLength; i++) {
            int index = word.charAt(i) - 'a';
            if (temp.tries[index] == null) {
                temp.tries[index] = new Trie5();
                // ham sirf object isliye bana rahe hai ki hamara wo index null na rahe
                // jo index null nahi hai aur wo TrieNode ka object rakhahai matlab wha wo character thi string me
            }
            //temp = temp.next ki tarah jaaisa linked list ke traversal me lagata hia
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

        return temp.endStatus;

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



/*
class Test{
    public static void main(String[] args) {
        Mandeep m = new Mandeep();

    }

   public static  class Mandeep{
        String name;
        int age;
        int[] arr = new int[26];
    }
}
*/
















