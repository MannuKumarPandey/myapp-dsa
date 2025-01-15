package MandeepDSA200HARD;

import java.util.*;

public class LC127WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest Transformation Length: " + result);
    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // End word is not in the word list.
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 1; // Begin word counts as the first step.

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                if (currentWord.equals(endWord)) { //BFS is giving the guarantee that as fast as we reach to the end word
                    //will be the shortest path
                    return steps;
                }

                for (String neighbor : getNeighbors(currentWord, wordSet)) {
                    queue.add(neighbor);
                    wordSet.remove(neighbor); // Avoid revisiting.
                }
            }
            steps++;
        }

        return 0; // If no path is found.
    }

    private static List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < wordArray.length; i++) {

            char originalChar = wordArray[i];//isake badale me a to z tak chars add kar rahe hai except original char

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue; //isake badale me a to z tak chars add kar rahe hai except original char

                wordArray[i] = c;
                String newWord = new String(wordArray); //every time preparing a new word

                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            wordArray[i] = originalChar; // Restore the original character.
        }

        return neighbors;
    }


}
