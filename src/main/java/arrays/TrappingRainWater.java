package arrays;

public class TrappingRainWater {

	public static void main(String[] args) {

		int array[] = new int[] { 3, 1, 6, 4, 5, 9, 8, 14, 20 };
		int length = array.length;
		int leftArray[] = new int[array.length];
		int rightArray[] = new int[array.length];

		leftArray[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			leftArray[i] = Math.max(leftArray[i - 1], array[i]);
		}

		rightArray[length - 1] = array[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			rightArray[i] = Math.max(rightArray[i + 1], array[i]);
		}

		int sum = 0;
		for (int i = 1; i < length - 1; i++) {
			sum = sum + Math.min(leftArray[i], rightArray[i]) - array[i];
		}
		System.out.println(sum);
	}

}
