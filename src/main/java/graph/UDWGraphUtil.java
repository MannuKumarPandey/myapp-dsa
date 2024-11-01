package graph;

import java.util.ArrayList;

public class UDWGraphUtil {
	
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
		PrintUDWGraph(getUDWGraphAdjList(), 8);
	}
	
	public static ArrayList<ArrayList<WeightedEdge>> getUDWGraphAdjList(){
		ArrayList<ArrayList<WeightedEdge>> adj = new ArrayList<ArrayList<WeightedEdge>>();

		int n= 8;
		for (int i = 0; i <= n; i++) 
			adj.add(new ArrayList<WeightedEdge>());

		adj.get(1).add(new WeightedEdge(2,2));
		adj.get(2).add(new WeightedEdge(1,2));

		adj.get(1).add(new WeightedEdge(6,14));
		adj.get(6).add(new WeightedEdge(1,14));
		
		adj.get(2).add(new WeightedEdge(3,3));
		adj.get(3).add(new WeightedEdge(2,3));
		
		adj.get(2).add(new WeightedEdge(4,5));
		adj.get(4).add(new WeightedEdge(2,5));
		
		adj.get(6).add(new WeightedEdge(7,20));
		adj.get(7).add(new WeightedEdge(6,20));
		
		adj.get(6).add(new WeightedEdge(8,15));
		adj.get(8).add(new WeightedEdge(6,15));
		
		adj.get(7).add(new WeightedEdge(5,10));
		adj.get(5).add(new WeightedEdge(7,10));
		
		adj.get(4).add(new WeightedEdge(5,9));
		adj.get(5).add(new WeightedEdge(4,9));
		
		return adj;
	}

	
	public static void PrintUDWGraph(ArrayList<ArrayList<WeightedEdge>> adjList , int n) {
		for(int i= 1; i<= n; i++) {
			System.out.print(i+ " is connected to ");
			for(int j= 0; j< adjList.get(i).size(); j++) {
				System.out.print(adjList.get(i).get(j).dest+"  with weight of "+ adjList.get(i).get(j).weight+"   ");
			}
			System.out.println();
		}
	}
}
