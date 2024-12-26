package randomtest;

import java.util.Stack;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverseWords("a good   example"));
	}

	public static String reverseWords(String s) {

		String arr[] = s.split(" ");
		String res = arr[arr.length-1];
		
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i].trim();
			if (arr[i] != "") {
				stack.push(arr[i]);
			}
		}

		while (!stack.isEmpty()) {
			res = res + " " + stack.pop();
		}
		return res;

	}
}
