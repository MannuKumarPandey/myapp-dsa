package MandeepDSA200Medium;

import java.util.ArrayList;
import java.util.List;

public class LC655PrintBinaryTree {


    public static void main(String[] args) {

    }

    List<List<String>> collect;

    public List<List<String>> printTree(TreeNode root) {
        int height = heightTree(root);
        collect = new ArrayList<>();
        int row = height + 1;
        int col = (int) Math.pow(2, height + 1) - 1;
        for (int i = 0; i < row; i++) {
            List<String> op = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                op.add("");
            }
            collect.add(op);
        }
        matrixMaker(root, 0, (col - 1) / 2, height);
        return collect;
    }

    public void matrixMaker(TreeNode root, int row, int col, int height) {
        if (root == null) {
            return;
        }
        collect.get(row).set(col, String.valueOf(root.val));
        matrixMaker(root.left, row + 1, col - ((int) Math.pow(2, height - row - 1)), height);
        matrixMaker(root.right, row + 1, col + ((int) Math.pow(2, height - 1 - row)), height);
    }

    public int heightTree(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = heightTree(root.left);
        int right = heightTree(root.right);
        return Math.max(left, right) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
