package binarysearchtree;

import java.util.*;

public class ModeInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
       /* root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);*/
        System.out.println(Arrays.toString(findMode(root)));
    }

    public static int[] findMode(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        List<Integer> traversalList = new ArrayList<>();
        inorderTraversal(root, traversalList);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int a : traversalList) {
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }
        int tempMax = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> a : hm.entrySet()) {
            int val = a.getValue();
            tempMax = Math.max(tempMax, val);
        }

        for (Map.Entry<Integer, Integer> a : hm.entrySet()) {
            int val = a.getValue();
            if (val == tempMax) {
                ansList.add(a.getKey());
            }
        }
        int lenn = ansList.size();
        int[] result = new int[lenn];
        for (int i = 0; i < lenn; i++) {
            result[i] = ansList.get(i);
        }
        return result;
    }

    public static void inorderTraversal(TreeNode root, List<Integer> traversalList) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inorderTraversal(root.left, traversalList);
        }

        traversalList.add(root.val);

        if (root.right != null) {
            inorderTraversal(root.right, traversalList);
        }
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
