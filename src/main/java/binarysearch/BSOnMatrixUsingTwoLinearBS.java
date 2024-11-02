package binarysearch;

public class BSOnMatrixUsingTwoLinearBS {

    public static void main(String[] args) {
        int arr[][] = new int[][]{{1, 2, 3}, {4, 15, 16}, {77, 88, 99}};
        int lastIndex = arr[0].length * arr.length;
        int target = 88;
        System.out.println(bsOnMatrix(arr, 0, lastIndex, target));
    }

    private static boolean bsOnMatrix(int[][] arr, int start, int last, int target) {

        // pahle ek row ko fix kar lete hai ki usame ye target value ki range me hai ya
        // nahi
        // agar wo row fix ho jat ahai tab sirf binary search in linear way se bhi lagha
        // sakte hai

        // but is approach me atleast O(n) time lega hi lega.

        // run a loop to find the row value which has the target in their rtanghes like
        // from first to last index

        return false;
    }

}

