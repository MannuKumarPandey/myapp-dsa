package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak1 {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dpArray = new boolean[s.length() + 1]; // trying to skip first index(0) and store all the characters index
        Set<String> set = new HashSet<>(); //to keep all the words of List<String> wordDict
        set.addAll(wordDict);

        dpArray[0] = true;  // is 0 index ko base termination condition bnayenge.
        for (int i = 1; i <= s.length(); i++) { // har ek index ko 1 se start karke length-1 tak le jayenge aur substring me last exclude bhi hoga
            for (int j = i - 1; j >= 0; j--) {// i se pahle ka har ek index par substring nikal kar ye check karenge ki kahi wo
                //substring HashSet me hai kya aur us index ko true mark kar denge matlab wha tak ka word 0 index se lekar ek word banakar dict me hai
                dpArray[i] = dpArray[j] && set.contains(s.substring(j, i));
                if (dpArray[i])  // jaise hi i ke pahle ka koi bhi index esa mila jo true ho matlab whi tak ka substring available hai dict me aur
                    // break kar denge inner iteration. agar koi nahi milega to 0 par paka hi milega
                    break;
            }
        }
        return dpArray[s.length()];
    }
}
