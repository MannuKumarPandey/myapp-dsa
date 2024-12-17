package priorityqueue;

import java.util.PriorityQueue;

class TrappingRainWaterProblem2 {

    public static void main(String[] args) {
        System.out.println(trapRainWater(new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}}));
    }

    public static int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }


        int m = heightMap.length;
        int n = heightMap[0].length;

        //Preparing minHeap on basis of height
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);
        boolean[][] visited = new boolean[m][n];

        // inserting all boundries cells into heap for starting the traversal
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));  //ith row with 0
            minHeap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));//ith row with last column
            visited[i][0] = true; //mark both visited array as true
            visited[i][n - 1] = true;//mark both visited array as true
        }
        for (int j = 0; j < n; j++) {
            minHeap.offer(new Cell(0, j, heightMap[0][j]));
            minHeap.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }


        int totalWater = 0;
        ///Movements can be in all 4 directions from any cell
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Starting the traversal with first minimum height
        while (!minHeap.isEmpty()) {
            Cell current = minHeap.poll();

            // moving in all 4 directions
            for (int[] dir : directions) {
                int x = current.row + dir[0];
                int y = current.col + dir[1];

                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) { //checking for boundaries and not visited already
                    visited[x][y] = true; //mark the newly reaching cell as visited

                    // new cell post adding the first directions if that is less than the boundry from where we are going there then only from that side
                    //some water as its difference will be getting stored
                    //There are two case , either the new reching cell will have lesser height then only difference will becaome greater than 0
                    //else in all case 0 will be added as water stored there.
                    totalWater += Math.max(0, current.height - heightMap[x][y]);

                    // Add newly reaching cell to the minHeap with updated effective height
                    //updated effective height will now become max of both new reaching cell and previous one from where we reached.

                    minHeap.offer(new Cell(x, y, Math.max(current.height, heightMap[x][y])));
                }
            }
        }

        return totalWater;
    }

    // Helper class to represent each cell
    static class Cell {
        int row, col, height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
