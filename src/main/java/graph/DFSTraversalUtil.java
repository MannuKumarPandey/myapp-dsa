package graph;

import java.util.ArrayList;

public class DFSTraversalUtil {

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
