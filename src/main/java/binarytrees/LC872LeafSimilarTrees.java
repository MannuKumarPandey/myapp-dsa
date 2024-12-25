package binarytrees;

import java.util.ArrayList;
import java.util.List;

public class LC872LeafSimilarTrees {


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);


        System.out.println(leafSimilar(root1, root2));
    }


    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        findLeafNodes(root1, res1);
        List<Integer> res2 = new ArrayList<>();
        findLeafNodes(root2, res2);
        return res1.equals(res2);
    }

    public static void findLeafNodes(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res.add(root.val);
        }

        findLeafNodes(root.left, res);
        findLeafNodes(root.right, res);
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
