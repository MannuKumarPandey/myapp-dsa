package alltemplates;

import java.util.LinkedList;
import java.util.Queue;

public class BFSOnTree {
    public void bfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    class TreeNode {
        int val;
        TreeNode left, right;
    }
}
