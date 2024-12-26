package recursion;

public class SumOfFirstNNumbers {

	public static void main(String[] args) {
		System.out.println(sumFirstNNumbers(1, 10));
	}

	public static int sumFirstNNumbers(int i, int n) {
		if (i > n) {
			return 0;
		}
		return i + sumFirstNNumbers(i + 1, n);
	}
}
