package binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintingAllNodesInLevelWise {

    // Method to print all nodes level by level
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }

        // Queue to facilitate BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level

            // Print all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                System.out.print(currentNode.val + " ");

                // Add left and right children to the queue
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            System.out.println(); // Move to the next line after printing a level
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Print level-order traversal
        System.out.println("Level-order traversal of the binary tree:");
        printLevelOrder(root);
    }

    // Definition of a TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
