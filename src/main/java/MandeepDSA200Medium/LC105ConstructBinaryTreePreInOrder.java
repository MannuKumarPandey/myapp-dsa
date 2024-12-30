package MandeepDSA200Medium;

import java.util.HashMap;


public class LC105ConstructBinaryTreePreInOrder {

    public static void main(String[] args) {
        int[] preorder = {3, 4, 2, 9, 10, 5, 7};
        int[] inorder = {2, 4, 9, 3, 5, 10, 7};

        TreeNode root = buildTree(preorder, inorder);
        printPostOrder(root); // Print Post order to verify the constructed tree
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // Using Hash Map to store inorder traversal in with its index
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Helper function to build the tree
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderMap) {
        // Base case
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        //First element is the pre order traversal is the root fpr tree / subtree
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // get the index of the root node from in order traversal
        int indexOfRootElement = inorderMap.get(rootVal);
        int leftTreeSize = indexOfRootElement - inStart;

        // Recursively build the left subtree
        root.left = build(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, indexOfRootElement - 1, inorderMap);

        // Recursively build the right subtree
        root.right = build(preorder, preStart + leftTreeSize + 1, preEnd, inorder, indexOfRootElement + 1, inEnd, inorderMap);

        return root;
    }

    // Helper function to print inorder traversal of the tree
    private static void printPostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
