package arrays;

public class MinimumNoOfMergeOperationsReqtoMakePalindorme {

	public static void main(String[] args) {

		int array[] = new int[] { 1, 3, 2, 4, 5, 7, 1 };
		int n = array.length;
		int ans = 0;

		for (int i = 0, j = n - 1; i <= j;) {
			// If corner elements are same,
			// problem reduces arr[i+1..j-1]
			if (array[i] == array[j]) {
				i++;
				j--;
			}

			// if left element is greater then merge two right elements
			else if (array[i] > array[j]) {
				// need to merge from tail.
				j--;
				array[j] += array[j + 1];
				ans++;
			}
			// merge left two elements
			else {
				i++;
				array[i] += array[i - 1];
				ans++;
			}
		}
		System.out.println(ans);
	}
}
