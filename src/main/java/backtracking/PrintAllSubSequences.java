package backtracking;

import java.util.ArrayList;

public class PrintAllSubSequences {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		int arr[] = { 3, 1, 2 };
		printAllTheSubSequences(0, arr, al);
	}

	private static void printAllTheSubSequences(int i, int[] arr, ArrayList<Integer> al) {
		if (i == arr.length) {
			for (int h : al) {
				System.out.print(h + " ");
			}
			System.out.println();
			return;
		}
		al.add(arr[i]);
		printAllTheSubSequences(i + 1, arr, al);
		// ek ek integer ko remove kar karke fir se newly take or not take kind of
		// case me badhate chale wo automatic sare sequences ko print kar dega.

		al.remove(Integer.valueOf(arr[i]));
		printAllTheSubSequences(i + 1, arr, al);

	}
}
