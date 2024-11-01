package recursion;

public class PrintStringNTimes {
	public static void main(String[] args) {
		printName(1, 10);
	}

	public static void printName(int i, int N) {

		// Base condition
		if (i > N) {
			return;
		}
		System.out.println("ABC");
		printName(i + 1, N);
	}
}
