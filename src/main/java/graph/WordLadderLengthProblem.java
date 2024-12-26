package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderLengthProblem {

	private static class Pair {
		private String first;
		private int second;

		public Pair(String first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) {
		String startWord = "der", targetWord = "dfs";
		String[] wordList = { "des", "der", "dfr", "dgt", "dfs" };
		System.out.println(wordLaddderLengthDetails(startWord, targetWord, wordList));
	}

	public static int wordLaddderLengthDetails(String startWord, String targetWord, String[] wordList) {

		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(startWord, 1));

		Set<String> hashSet = new HashSet<String>();
		int len = wordList.length;

		for (int i = 0; i < len; i++) {
			hashSet.add(wordList[i]);
		}

		hashSet.remove(startWord);

		while (!queue.isEmpty()) {
			String word = queue.peek().first;
			int steps = queue.peek().second;

			queue.remove();

			if (word.equals(targetWord)) {
				return steps;
			}

			for (int i = 0; i < word.length(); i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char[] replacedCharArray = word.toCharArray();
					replacedCharArray[i] = ch;
					String replacedString = new String(replacedCharArray);
					if (hashSet.contains(replacedString) == true) {
						hashSet.remove(replacedString);
						queue.add(new Pair(replacedString, steps + 1));
					}

				}
			}
		}
		return 0;
	}
}
