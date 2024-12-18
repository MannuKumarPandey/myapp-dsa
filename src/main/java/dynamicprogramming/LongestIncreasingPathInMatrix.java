package dynamicprogramming;

public class LongestIncreasingPathInMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int[][] dp = new int[row][column];

        int maxLengthResult = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                maxLengthResult = Math.max(maxLengthResult, dfs(matrix, i, j, dp, row, column));
            }
        }
        return maxLengthResult;

    }

    private static int dfs(int[][] matrix, int i, int j, int[][]dp, int rowLen , int colLen) {

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int[] directions = {-1,0,1,0,0,-1, 0,1};

        int maxPath = 1;
        for(int p = 0; p<4; p++ ){
            int newRow = i+directions[p*2];
            int newCol = j+directions[p*2+1];

            if(newRow >= 0 && newRow < rowLen && newCol >= 0 && newCol < colLen && matrix[newRow][newCol] > matrix[i][j]){
                maxPath = Math.max(maxPath, 1+dfs(matrix, newRow, newCol, dp, rowLen, colLen));
            }
        }
        dp[i][j] = maxPath;
        return maxPath;

    }
}
