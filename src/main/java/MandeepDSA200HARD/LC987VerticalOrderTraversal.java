package MandeepDSA200HARD;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC987VerticalOrderTraversal {

    public static PriorityQueue<Pair> pq;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(verticalTraversal(root).toString());
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a.x != b.x)
                return a.x - b.x;
            else if (a.y != b.y)
                return a.y - b.y;
            else
                return a.val - b.val;
        });

        dfs(root, 0, 0);


        ///printing the pq info which has all the nodes details
        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Pair poll = pq.poll();
            list.add(poll.val);
            while (!pq.isEmpty() && pq.peek().x == poll.x) {
                list.add(pq.poll().val);
            }
            result.add(list);
        }
        return result;
    }

    private static void dfs(TreeNode root, int x, int y) {
        if (root == null)
            return;
        pq.offer(new Pair(root.val, x, y));
        dfs(root.left, x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }

    public static class Pair {
        int val;
        int x;
        int y;

        Pair(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
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
