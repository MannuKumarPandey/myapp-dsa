package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UDUWGraphBFSTraversal {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj  = UDUWGraphUtil.getUDUWGraphAdjList();
		int n = 8;
		
		ArrayList<Integer> bfsTraversalList = new ArrayList<Integer>();
		
		// create a queue to store and perform the BFS traversal operation
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// create a visited array to contain the details of the visited nodes 
		boolean []vis = new boolean[9];
		
		// starting node will be given from where we need to start the BFS traversal
		int startingNode =1;
		
		// keep starting node in the queue first and mark the same as visited in vis array
		queue.add(startingNode);
		vis[startingNode] = true;
		
		
		while(!queue.isEmpty()) {
			int curNode = queue.poll();
			bfsTraversalList.add(curNode);
			
			for(int s: adj.get(curNode)) {
				if(!vis[s]) {
					queue.add(s);
					vis[s] = true;
				}
			}
		}
		
		for(int h: bfsTraversalList) {
			System.out.print(h+ " ");
		}
	}
}
