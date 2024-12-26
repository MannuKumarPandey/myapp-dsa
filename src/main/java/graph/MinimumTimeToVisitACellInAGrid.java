package graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumTimeToVisitACellInAGrid {

    public static void main(String[] args) {
        System.out.println(minimumTime(new int[][]{{0, 1, 3, 2}, {5, 1, 2, 5}, {4, 3, 8, 6}}));
    }

    public static int minimumTime(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        //check if movement can be started or not
        if (Math.min(grid[0][1], grid[1][0]) > 1) {
            return -1;
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        //PriorityQueue is storing values as {time, row, col} and sorting on basis of time
        pq.add(new int[]{0, 0, 0});

        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int x = current[1];
            int y = current[2];

            //if row and column is already reching the last boundry
            if (x == row - 1 && y == col - 1) {
                return time;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < row && newY >= 0 && newY < col && !visited[newX][newY]) {
                    int waitingTime = 0;
                    int diff = Math.abs(grid[newX][newY] - time);

                    if ((diff & 1) == 0)
                        waitingTime = 1;

                    int newTime = Math.max(grid[newX][newY] + waitingTime, time + 1);
                    pq.add(new int[]{newTime, newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        return -1;
    }
}
