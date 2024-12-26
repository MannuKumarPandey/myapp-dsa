package binarytrees;

public class IsHightBalancedBinaryTree {

    public static void main(String[] args) {

        /* Key point is there should not be any hight factor as greater than 1 and less that -1*/
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(70);


        System.out.println(isBalanced(root));
    }


    public static boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) < 2 && isBalanced(root.left)
                && isBalanced(root.right) ? true : false;

    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

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
