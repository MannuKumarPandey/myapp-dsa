package recursion;

import java.util.ArrayList;

public class RatInAMazeProblem {
	public static void main(String[] args) {

		int n = 4;
		int[][] a = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		ArrayList<String> res = findPath(a, n);
		if (res.size() > 0) {
			for (int i = 0; i < res.size(); i++)
				System.out.print(res.get(i) + " ");
			System.out.println();
		} else {
			System.out.println(-1);
		}
	}

	private static void solve(int i, int j, int a[][], int n, ArrayList<String> ans, String move, int vis[][]) {
		if (i == n - 1 && j == n - 1) { // at destination
			ans.add(move);
			return;
		}

		// Travelling in lexicographically Order DLRU

		// downward
		// conditions checked are : row < n-1 and not visited and cell value is 1
		if (i + 1 < n && vis[i + 1][j] == 0 && a[i + 1][j] == 1) {
			vis[i][j] = 1;
			solve(i + 1, j, a, n, ans, move + 'D', vis);
			vis[i][j] = 0;
		}

		// left
		// conditions checked are : column >= 0 and not visited and cell value is 1
		if (j - 1 >= 0 && vis[i][j - 1] == 0 && a[i][j - 1] == 1) {
			vis[i][j] = 1;
			solve(i, j - 1, a, n, ans, move + 'L', vis);
			vis[i][j] = 0;
		}

		// right
		// conditions checked are : column < n-1 and not visited and cell value is 1
		if (j + 1 < n && vis[i][j + 1] == 0 && a[i][j + 1] == 1) {
			vis[i][j] = 1;
			solve(i, j + 1, a, n, ans, move + 'R', vis);
			vis[i][j] = 0;
		}

		// upward
		// conditions checked are : row >= 0 and not visited and cell value is 1
		if (i - 1 >= 0 && vis[i - 1][j] == 0 && a[i - 1][j] == 1) {
			vis[i][j] = 1;
			solve(i - 1, j, a, n, ans, move + 'U', vis);
			vis[i][j] = 0;
		}
	}

	public static ArrayList<String> findPath(int[][] m, int n) {
		int vis[][] = new int[n][n]; // creating a visited array in 2D matrix

		// initializing all the cells of visited array as 0

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				vis[i][j] = 0;
			}
		}

		ArrayList<String> ans = new ArrayList<>();
		if (m[0][0] == 1) // starting index 0 and 0 with value as 1
			solve(0, 0, m, n, ans, "", vis);
		return ans;
	}

}
