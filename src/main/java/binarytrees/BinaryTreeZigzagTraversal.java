package binarytrees;

import java.util.*;

public class BinaryTreeZigzagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(root).toString());
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) {
            return result;
        }
        queue.add(root);
        int p = -1;
        while (!queue.isEmpty()) {
            int sizeTemp = queue.size();
            List<Integer> tempRes = new ArrayList<>();
            while (sizeTemp-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                tempRes.add(curr.val);
            }
            p++;
            if(p%2 == 0){
                result.add(tempRes);
            }else{
                Collections.reverse(tempRes);
                result.add(tempRes);
            }

        }
        return result;
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
