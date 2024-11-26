package binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();

        TreeNode root = new TreeNode(10, null, null);
        root.left = new TreeNode(20, null, null);
        root.right = new TreeNode(30, null, null);
        root.left.left = new TreeNode(40, null, null);
        root.left.right = new TreeNode(50, null, null);
        root.right.left = new TreeNode(60, null, null);
        root.right.right = new TreeNode(70, null, null);
        root.right.right.right = new TreeNode(700, null, null);
        rightView(root, result);
        System.out.println(result.toString());
    }

    private static void rightView(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            result.add(queue.peek().data);

            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
            }

        }


    }

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
