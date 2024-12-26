package binarysearchtree;

class TreeNode {
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

class ValidateBinarySearchTree {

    public static void main(String[] args) {

        /*
         * TreeNode head = new TreeNode(2); head.left = new TreeNode(1); head.right =
         * new TreeNode(3); System.out.println(new
         * ValidateBinarySearchTree().isValidBST(head));
         */


        /*
         * TreeNode head = new TreeNode(5); head.left = new TreeNode(1); head.right =
         * new TreeNode(4); head.right.left = new TreeNode(3); head.right.right = new
         * TreeNode(6); System.out.println(new
         * ValidateBinarySearchTree().isValidBST(head));
         */


        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(4);
        head.right = new TreeNode(6);
        head.right.left = new TreeNode(3);
        head.right.right = new TreeNode(7);
        System.out.println(new ValidateBinarySearchTree().isValidBST(head));

    }

    public boolean isValidBST(TreeNode root) {

        return isBST(root);
    }

    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.val >= root.val) {
            return false;
        }

        if (root.right != null && root.right.val <= root.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }
}


