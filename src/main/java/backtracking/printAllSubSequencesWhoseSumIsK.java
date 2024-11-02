package backtracking;

import java.util.ArrayList;

public class printAllSubSequencesWhoseSumIsK {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		int arr[] = { 3, 1, 2 };
		int k = 3;
		printAllTheSubSequences(0, arr, al, k);
	}

	private static void printAllTheSubSequences(int i, int[] arr, ArrayList<Integer> al, int K) {
		if (i == arr.length) {
			int sum = 0;
			for (int h : al) {
				sum = sum + h;
			}
			if (sum == K) {
				for (int h : al) {
					System.out.print(h + " ");
				}
				System.out.println();
				return;
			}
			return;
		}
		al.add(arr[i]);
		printAllTheSubSequences(i + 1, arr, al, K);
		// ek ek integer ko remove kar karke fir se newly take or not take kind of
		// case me badhate chale wo automatic sare sequences ko print kar dega.

		al.remove(Integer.valueOf(arr[i]));
		printAllTheSubSequences(i + 1, arr, al, K);

	}

}
