package arrays;

public class LargestSumContigeousSumArray {
	public static void main(String[] args) {

		// esa contineous sub array nikaliye jiska sum sabse jyada ho
		int maxSum = 0;
		int temp = 0;

		int array[] = new int[] { 2, 1, -3, 4, -5, 7, 8, -2 };
		for (int i = 0; i <= array.length - 1; i++) {
			if (maxSum > maxSum + array[i]) {
				temp = maxSum;
				maxSum = 0;
			} else if (maxSum < maxSum + array[i] && temp < maxSum + array[i]) {
				maxSum = maxSum + array[i];
				temp = maxSum;
			}
		}
		System.out.println(temp);
	}
}
