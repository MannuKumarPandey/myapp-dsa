package arrays;

public class DuplicateInAnArrayofNplus1Ints {

	public static void main(String[] args) {
		int array[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 10 };
		int expSum = 10 * (10 + 1) / 2;
		int actualSum = 0;
		for (int h : array) {
			actualSum += h;
		}
		System.out.println(actualSum - expSum);
	}
}
