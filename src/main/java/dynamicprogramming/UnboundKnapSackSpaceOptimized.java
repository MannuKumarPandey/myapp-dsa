package dynamicprogramming;

public class UnboundKnapSackSpaceOptimized {
	
	
	public static void main(String args[]) {

		  int wt[] = {2,4,6};
		  int val[] = {5,11,13};
		  int W=10;
		  
		  int n = wt.length;
		                                 
		  System.out.println("The Maximum value of items, thief can steal is : "+unboundedKnapsack(n,W,val,wt));
		}

	
	static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {

		int cur[] = new int[W + 1];

		// Base Condition

		for (int i = wt[0]; i <= W; i++) {
			cur[i] = ((int) i / wt[0]) * val[0];
		}

		for (int ind = 1; ind < n; ind++) {
			for (int cap = 0; cap <= W; cap++) {

				int notTaken = cur[cap];

				int taken = Integer.MIN_VALUE;
				if (wt[ind] <= cap)
					taken = val[ind] + cur[cap - wt[ind]];

				cur[cap] = Math.max(notTaken, taken);
			}
		}

		return cur[W];

	}
}
