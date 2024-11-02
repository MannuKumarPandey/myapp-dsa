package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalOfAMatrix {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).toString());
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int top = 0, left = 0, bottom = matrix.length -1,  right = matrix[0].length-1;

        int total = matrix.length * matrix[0].length;

        while( result.size() < total ){

            //left to right
            for( int i = left; i <= right && result.size() < total ; i++){
                result.add(matrix[top][i]);
            }
            top++;

            //top to bottom
            for( int i = top; i <= bottom && result.size() < total; i ++){
                result.add(matrix[i][right]);
            }
            right--;

            // right to left
            for( int i = right; i >= left && result.size() < total; i-- ){
                result.add(matrix[bottom][i]);
            }
            bottom--;

            //bottom to top
            for( int i = bottom; i >= top && result.size() < total; i-- ){
                result.add(matrix[i][left]);
            }
            left++;

        }
        return result;
    }
}
