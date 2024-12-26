package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversalOfAGraph {

    public static void main(String[] args) {
        // System.out.println(bfsTraversal(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 }
        // }, 0).toString());
        System.out.println(bfsTraversal(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}, 1).toString());
    }

    public static ArrayList<Integer> bfsTraversal(int n, int[][] edges, int source) {
        ArrayList<Integer> bfsTraversalList = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> adjList = buildUnDirectedGraph(n, edges);// Matrix se adjacency List me graph
        // banawalo
        boolean[] visitedArray = new boolean[n];// Jitani vertices hai un sab ko bari bari se visit karne ke liye
        // created visited Array
        Arrays.fill(visitedArray, false);// initializing the visited array as false
        /*
         * Jab Traversal Adjacency List me rakhe graph par ho rahi ho to visited array
         * no of vertices of the graph (Dhyan rakhe ki graph 0 index based hai ya 1
         * index based) ke liye sirf 1D array me rak sakte hai
         *
         *
         * Agar Adjancency Matrix me rakhkar graph ki traversal kar rahe hai tab mostly
         * 2D array as visited array banakar karna better option hoga because we need to
         * take care of all the rows and columns too.
         *
         */

        Queue<Integer> queue = new LinkedList<Integer>(); // Using Queue because FIFO ki properties chaihye BFS ke liye
        queue.add(source);// First source node ko add kiya qki usi se traversal start karwani thi
        while (!queue.isEmpty()) { // loop ko tabtak chalaye jabtak queue puri tarah se khali na ho jaye
            int listC = queue.poll(); // queue se first element nikaliye
            if (!visitedArray[listC]) { // agar wo element pahle se visited nahi ho
                visitedArray[listC] = true; // to eske corresponsing visited array me true mark kijiye
                bfsTraversalList.add(listC);// result wali list me add kijiye
            }
            ArrayList<Integer> childrens = adjList.get(listC);// sare children ko lijiye and one by one usko fir se
            // queue me dalte chaliye
            for (Integer c : childrens) {
                if (!visitedArray[c]) {
                    queue.offer(c);
                }
            }
        }
        return bfsTraversalList;
    }

    public static ArrayList<ArrayList<Integer>> buildUnDirectedGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        return adjList;
    }

}

