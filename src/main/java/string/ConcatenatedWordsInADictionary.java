package string;

import java.util.*;

public class ConcatenatedWordsInADictionary {

    public static void main(String[] args) {
        System.out.println(findAllConcatenatedWordsInADict(new String[]{"catsdogcats","dogcats","cat", "cats",  "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}).toString());
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();

        Set<String> lookupSet = new HashSet<String>();
        for (String word : words) {
            lookupSet.add(word);
        }

        Map<String, Boolean> mapDP = new HashMap<>();
        for (String curr : words) {
            // we will temporarly remove from hashset
            lookupSet.remove(curr);

            Boolean flag = canBeFormed(curr, lookupSet, mapDP);
            if (flag) {
                result.add(curr);
            }
            lookupSet.add(curr);
        }
        return result;
    }

    public static boolean canBeFormed(String word, Set<String> lookupSet, Map<String, Boolean> mapDP) {
        if (mapDP.containsKey(word)) {
            return mapDP.get(word);
        }

        for (int i = 1; i < word.length(); i++) {
            String prefixString = word.substring(0, i);
            String suffixString = word.substring(i);

            if (lookupSet.contains(prefixString)) {
                if(lookupSet.contains(suffixString) || canBeFormed(suffixString, lookupSet, mapDP)){
                    mapDP.put(word, true);
                    return true;
                }

            }
        }
        mapDP.put(word, false);
        return false;
    }
}