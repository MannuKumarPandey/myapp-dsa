package dynamicprogramming;

public class FibonacciNumber {

	public static void main(String[] args) {
		int n = 5;
		int dp[] = new int[n+1]; // array to store the computed results
		for (int i = 0; i < n+1; i++) {
			dp[i] = -1;
		}
		System.out.println(fibonacciByMemoization(n, dp));
		System.out.println(fibonacciByTabulation(n, dp));
	}

	private static int fibonacciByTabulation(int n, int[] dp) {
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i =2; i< n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}

	private static int fibonacciByMemoization(int n, int[] dp) {

		if (n <= 1) {
			return n;
		}

		// Agar pahle se same overlapping sub problems solve karke rakha hua hai dp array me
		// to usi me se result ko return kar do calling recursion for computed result is
		// not required.
		if (dp[n] != -1) {
			return dp[n];
		}

		// agar koi naya n ke liye fibonacci find kiya gya to usko dp[] me store kar
		// dete
		// hai taki future me same ke liye koi dusra computation na karna pade.
		return dp[n] = fibonacciByMemoization(n - 1, dp) + fibonacciByMemoization(n - 2, dp);
	}
}
