package alltemplates;

public class DFSOnTree {
    public void dfs(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val); // Pre-order traversal
        dfs(root.left);
        dfs(root.right);
    }

    class TreeNode {
        int val;
        TreeNode left, right;
    }
}
