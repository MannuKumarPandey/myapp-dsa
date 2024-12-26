package recursion;

public class FibonacciNumber {

	public static void main(String[] args) {
		System.out.println(fibonacci(4));
	}

	private static int fibonacci(int n) {

		if (n <= 1) {
			return n;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
		
		// in above two recursion calls first will be completed first and then second will be called and 
		// will bring the result and add the same .
	}
}
