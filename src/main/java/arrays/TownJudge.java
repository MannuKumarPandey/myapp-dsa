package arrays;

import java.util.Arrays;

public class TownJudge {


    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{{1, 2}}));
    }


    public static int findJudge(int n, int[][] trust) {

        int[] outDegree = new int[n + 1];
        int[] inDegree = new int[n + 1];
        Arrays.fill(outDegree, 0);
        Arrays.fill(inDegree, 0);

        for (int i = 0; i < trust.length; i++) {
            int currentD = trust[i][0];
            outDegree[currentD] = outDegree[currentD] + 1;

            int inDegreeD = trust[i][1];
            inDegree[inDegreeD] = inDegree[inDegreeD] + 1;
        }

        for (int i = 1; i <= n; i++) {
            if (outDegree[i] == 0 && inDegree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

}

