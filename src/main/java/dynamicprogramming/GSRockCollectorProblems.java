package dynamicprogramming;
/*The Rock Collector Puzzle (Grid Path Problem)
Problem Overview

You are an avid rock collector living in Southern California (So_Cal), aiming to travel to New York (NY).
A grid represents cities, with each cell containing a number indicating the count of rare (desirable) rocks available there

You can only move north (up) or east (right) through the grid.
The goal: find the path from So_Cal to New_York that maximizes the total rocks collected.
        Example:
Grid:
        {2, 0, 0, 0, 0}
        {0, 1, 1, 1, 0}
        {0, 0, 0, 0, 5}
Paths only move up or right.
One such path: 2 → 0 → 1 → 1 → 1 → 0 → 5 = Total rocks: 10*/

public class GSRockCollectorProblems {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 5}
        };

        System.out.println("Maximum rocks collected: " + maxRocks(grid));
    }

    public static int maxRocks(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Memo table initialized with -1
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        // Start at bottom-left (m-1, 0), target = top-right (0, n-1)
        return collect(grid, m - 1, 0, memo);
    }

    // Recursive function: returns max rocks to reach (i, j) from bottom-left
    private static int collect(int[][] grid, int i, int j, int[][] memo) {
        int m = grid.length;
        int n = grid[0].length;

        // Base case: reached target (top-right)
        if (i == 0 && j == n - 1) return grid[i][j];

        // Out of bounds
        if (i < 0 || j >= n) return Integer.MIN_VALUE;

        // Already computed
        if (memo[i][j] != -1) return memo[i][j];

        // Move up (north) or right (east)
        int moveUp = collect(grid, i - 1, j, memo);
        int moveRight = collect(grid, i, j + 1, memo);

        memo[i][j] = Math.max(moveUp, moveRight) + grid[i][j];
        return memo[i][j];
    }
}





















