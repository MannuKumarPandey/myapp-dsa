package recursion;

import java.util.ArrayList;

public class CountTheNoOfSubSequencesWithSumK {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		int arr[] = { 3, 1, 2, -1 };
		int k = 3;
		int result = 0;
		System.out.println(printAllTheSubSequences(0, arr, al, k, result));
	}

	private static int printAllTheSubSequences(int i, int[] arr, ArrayList<Integer> al, int K, int result) {

		if (i == arr.length) {
			int sum = 0;
			for (int h : al) {
				sum = sum + h;
			}
			if (sum == K) {

				return 1;
			}
			return 0;
		}
		al.add(arr[i]);

		int leftCount = printAllTheSubSequences(i + 1, arr, al, K, result);
		// ek ek integer ko remove kar karke fir se newly take or not take kind of
		// case me badhate chale wo automatic sare sequences ko print kar dega.

		al.remove(Integer.valueOf(arr[i]));

		int rightCount = printAllTheSubSequences(i + 1, arr, al, K, result);
		return leftCount + rightCount;
	}

}
