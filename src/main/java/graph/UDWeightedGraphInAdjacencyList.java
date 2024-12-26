package graph;

import java.util.ArrayList;

public class UDWeightedGraphInAdjacencyList {
	private static ArrayList<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();
	
	// Niche likhe class Edge ka use isliye karna pada qki ye given graph Undirected with Weight hai 
	// To source to destination ke sath sath usaka weight bhi store karna padega jiskae 
	// liye hame Edge ya Pair name se ek class Banana padega 
	
	public static class Edge{
		int destination;
		int weight;
		public Edge(int destination, int weight) {
			super();
			this.destination = destination;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {

		// Lets assume we have 10 nodes in the given graph
		// so create 10+1 empty objects of ArrayLisyList<Edge> and store in the same adjacency List
		for(int i = 0; i<=10; i++) {
			adjList.add(new ArrayList<Edge>());
		}
		
		
		addDirectedGrapgh(2, 4, 500);
		addDirectedGrapgh(2, 7, 500);
		addDirectedGrapgh(5, 4, 56660);
		addDirectedGrapgh(3, 4, 5066660);
		addDirectedGrapgh(2, 4, 5045450);
		addUnDirectedGrapgh(7,6, 6999);
		print();
	}
	
	private static void addDirectedGrapgh(int src, int dest, int weight) {
		adjList.get(src).add(new Edge(dest, weight));
	}
	
	private static void addUnDirectedGrapgh(int src, int dest, int weight) {
		//Since the given graph is the undirected means we have to add both the ways of traversal
		adjList.get(src).add(new Edge(dest, weight));
		adjList.get(dest).add(new Edge(src, weight));
	}

	public static void print() {
		for(int i= 0;i<=10;i++) {
			System.out.print("vertez "+i +" is connected to ");
			for(Edge ff: adjList.get(i)) {
				System.out.print("( "+ ff.destination+" ,"+ff.weight+" )");
			}
			System.out.println();
		}
	}
	
}
