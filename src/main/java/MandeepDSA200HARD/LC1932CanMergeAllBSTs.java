package MandeepDSA200HARD;

import java.util.*;

class LC1932CanMergeAllBSTs {
    public static void main(String[] args) {
        // Example Test Case
        List<TreeNode> trees = new ArrayList<>();

        // Tree 1: [2, 1]
        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(1);
        trees.add(tree1);

        // Tree 2: [3, 2, 5]
        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(5);
        trees.add(tree2);

        // Tree 3: [5, 4]
        TreeNode tree3 = new TreeNode(5);
        tree3.left = new TreeNode(4);
        trees.add(tree3);

        LC1932CanMergeAllBSTs solution = new LC1932CanMergeAllBSTs();
        TreeNode result = solution.canMerge(trees);

        // Print the result as an in-order traversal of the merged BST
        if (result != null) {
            System.out.print("Merged BST (In-order): ");
            inOrder(result);
        } else {
            System.out.println("Cannot merge the given trees into a single valid BST.");
        }
    }

    private static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    public TreeNode canMerge(List<TreeNode> trees) {
        //Collect the leaves
        Set<Integer> leaves = new HashSet();
        Map<Integer, TreeNode> map = new HashMap<>();
        for(TreeNode tree : trees) {
            map.put(tree.val, tree);
            if(tree.left != null) {
                leaves.add(tree.left.val);
            }
            if(tree.right != null) {
                leaves.add(tree.right.val);
            }
        }

        //Decide the root of the resulting tree
        TreeNode result = null;
        for(TreeNode tree : trees) {
            if(!leaves.contains(tree.val) ) {
                result = tree;
                break;
            }
        }
        if(result == null) {
            return null;
        }

        return traverse(result, map, Integer.MIN_VALUE, Integer.MAX_VALUE) && map.size() == 1 ? result : null;
    }

    private boolean traverse(TreeNode root, Map<Integer, TreeNode> map, int min, int max) {
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        if(root.left == null && root.right == null) {
            if(map.containsKey(root.val) && root != map.get(root.val)) {
                TreeNode next = map.get(root.val);
                root.left = next.left;
                root.right = next.right;
                map.remove(root.val);
            }
        }
        return traverse(root.left, map, min, root.val) && traverse(root.right, map, root.val, max);
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

// Definition for a binary tree node.


