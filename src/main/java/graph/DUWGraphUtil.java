package graph;

import java.util.ArrayList;

public class DUWGraphUtil {

	
	public static void main(String[] args) {
		PrintDUWGraph(getDUWGraphAdjList(), 8);
	}
	
	public static ArrayList<ArrayList<Integer>> getDUWGraphAdjList(){
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int n= 8;
		for (int i = 0; i <= n; i++) 
			adj.add(new ArrayList<Integer>());

		adj.get(1).add(2);// 1 to 2
		

		adj.get(1).add(6);// 1 to 6
		
		
		adj.get(2).add(3);// 2 to 3
	
		
		adj.get(2).add(4); // 2 to 4
		
		
		adj.get(6).add(7); // 6 to 7
		
		
		adj.get(6).add(8);// 6 to 8 
		
		
		adj.get(7).add(5);// 7 to 5
		
		
		adj.get(4).add(5); // 4 to 5
		
		
		return adj;
	}

	
	public static void PrintDUWGraph(ArrayList<ArrayList<Integer>> adjList , int n) {
		for(int i= 1; i<= n; i++) {
			System.out.print(i+ " is connected to ");
			for(int j= 0; j< adjList.get(i).size(); j++) {
				System.out.print(adjList.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	



}
