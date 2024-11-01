package graph;

import java.util.ArrayList;

public class UDUWGraphUtil {
	
	public static void main(String[] args) {
		PrintUDUWGraph(getUDUWGraphAdjList(), 8);
	}
	
	public static ArrayList<ArrayList<Integer>> getUDUWGraphAdjList(){
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		int n= 8;
		for (int i = 0; i <= n; i++) 
			adj.add(new ArrayList<Integer>());

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(1).add(6);
		adj.get(6).add(1);
		
		adj.get(2).add(3);
		adj.get(3).add(2);
		
		adj.get(2).add(4);
		adj.get(4).add(2);
		
		adj.get(6).add(7);
		adj.get(7).add(6);
		
		adj.get(6).add(8);
		adj.get(8).add(6);
		
		adj.get(7).add(5);
		adj.get(5).add(7);
		
		adj.get(4).add(5);
		adj.get(5).add(4);
		
		return adj;
	}

	
	public static void PrintUDUWGraph(ArrayList<ArrayList<Integer>> adjList , int n) {
		for(int i= 1; i<= n; i++) {
			System.out.print(i+ " is connected to ");
			for(int j= 0; j< adjList.get(i).size(); j++) {
				System.out.print(adjList.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	

}
