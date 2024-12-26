package recursion;

public class Printing100digits {

	public static void main(String[] args) {
		print(100);

	}

	public static void print(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		print(n - 1);

	}

}
