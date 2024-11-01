package graph;

import java.util.ArrayList;

public class DWGraphUtil {

	
	public static class WeightedEdge{
		int dest;
		int weight;
		public WeightedEdge(int dest, int weight) {
			super();
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) {
		PrintDWGraph(getDWGraphAdjList(), 8);
	}
	
	public static ArrayList<ArrayList<WeightedEdge>> getDWGraphAdjList(){
		ArrayList<ArrayList<WeightedEdge>> adj = new ArrayList<ArrayList<WeightedEdge>>();

		int n= 8;
		for (int i = 0; i <= n; i++) 
			adj.add(new ArrayList<WeightedEdge>());

		adj.get(1).add(new WeightedEdge(2,100));

		adj.get(1).add(new WeightedEdge(6,50));
		
		adj.get(2).add(new WeightedEdge(3,10));
		
		adj.get(2).add(new WeightedEdge(4,20));
		
		adj.get(6).add(new WeightedEdge(7,75));
		
		adj.get(6).add(new WeightedEdge(8,90));
		
		adj.get(7).add(new WeightedEdge(5,15));
		
		adj.get(4).add(new WeightedEdge(5,100));
		
		return adj;
	}

	
	public static void PrintDWGraph(ArrayList<ArrayList<WeightedEdge>> adjList , int n) {
		for(int i= 1; i<= n; i++) {
			System.out.print(i+ " is connected to ");
			for(int j= 0; j< adjList.get(i).size(); j++) {
				System.out.print(adjList.get(i).get(j).dest+"  with weight of "+ adjList.get(i).get(j).weight+"   ");
			}
			System.out.println();
		}
	}


}
