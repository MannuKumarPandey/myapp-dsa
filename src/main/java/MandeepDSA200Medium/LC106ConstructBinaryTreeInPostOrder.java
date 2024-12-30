package MandeepDSA200Medium;


import java.util.HashMap;


public class LC106ConstructBinaryTreeInPostOrder {


    public static void main(String[] args) {
        int[] inorder = {2, 4, 9, 3, 5, 10, 7};
        int[] postorder = {2, 9, 4, 5, 7, 10, 3};

        TreeNode root = buildTree(inorder, postorder);
        printPreorder(root); // To verify the constructed tree
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // Map to store value -> index mappings for inorder traversal
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Helper function to build the tree
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
    }

    private static TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> inorderMap) {
        // Base case
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // Root value is the last element in the current postorder segment
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // Find the root index in inorder traversal
        int inRoot = inorderMap.get(rootVal);
        int leftTreeSize = inRoot - inStart;

        // Recursively build the left subtree
        root.left = build(inorder, inStart, inRoot - 1, postorder, postStart, postStart + leftTreeSize - 1, inorderMap);

        // Recursively build the right subtree
        root.right = build(inorder, inRoot + 1, inEnd, postorder, postStart + leftTreeSize, postEnd - 1, inorderMap);

        return root;
    }

    // Helper function to print inorder traversal of the tree
    private static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
