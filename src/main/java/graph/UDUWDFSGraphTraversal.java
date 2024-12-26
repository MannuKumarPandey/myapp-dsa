package graph;

import java.util.ArrayList;

public class UDUWDFSGraphTraversal {


	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj  = UDUWGraphUtil.getUDUWGraphAdjList();
		int n = 8;
		
		// create a visited array to contain the details of the visited nodes 
		boolean []vis = new boolean[9];
		
		// starting node will be given from where we need to start the BFS traversal
		int startingNode =1;
		
		ArrayList<Integer> dfsTraversalList = new ArrayList<Integer>();
		dfsTraversalList =	dfs(dfsTraversalList, adj, startingNode, vis);
		
		
		for(int h: dfsTraversalList) {
			System.out.print(h+ " ");
		}
	}
	
	private static ArrayList<Integer> dfs(ArrayList<Integer> dfsTraversalList,
			ArrayList<ArrayList<Integer>> adj, int startNode , boolean vis[]){
		dfsTraversalList.add(startNode);
		vis[startNode] = true;
		
		for(int h: adj.get(startNode)) {
			if(vis[h] == false) {
				dfs(dfsTraversalList, adj, h, vis);
			}
		}
		
		return dfsTraversalList;
	}

}
