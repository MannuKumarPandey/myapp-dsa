package graph;

public class NoOfIslands {

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));
    }

    public static int numIslands(char[][] M) {
        int ROW = M.length;
        int COL = M[0].length;
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == '1') {
                    count++;
                    DFS(M, i, j, ROW, COL); // traversal starts from
                    // current cell
                }
            }
        }
        return count;

    }

    static void DFS(char[][] M, int i, int j, int ROW, int COL) {

        // Base condition
        // if i less than 0 or j less than 0 or i greater
        // than ROW-1 or j greater than COL- or if M[i][j]
        // != 1 then we will simply return
        if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != '1') {
            return;
        }

        if (M[i][j] == '1') { // logic ye laga rha hai ki jis bhi land ke cell ko visit kiya usko 0 se replace
            // kar de rha ahi so visited Array ko maintain nahi karna padega
            M[i][j] = '0';
            DFS(M, i + 1, j, ROW, COL); // right side traversal
            DFS(M, i - 1, j, ROW, COL); // left side traversal
            DFS(M, i, j + 1, ROW, COL); // upward side traversal
            DFS(M, i, j - 1, ROW, COL); // downward side traversal

            // digonal movements
            DFS(M, i + 1, j + 1, ROW, COL); // upward-right side traversal
            DFS(M, i - 1, j - 1, ROW, COL); // downward-left side traversal
            DFS(M, i + 1, j - 1, ROW, COL); // downward-right side traversal
            DFS(M, i - 1, j + 1, ROW, COL); // upward-left side traversal
        }
    }

}
