package graph;

import java.util.ArrayList;

public class DUWGraphInAdjList {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		//Since given number of nodes in graph is n  so kindly create n+1 empty list and store in the adj list
		for(int i = 0; i<= 10; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		
		// Add node 1 to 3: So since given graph is directed that means 
		// we have only one option to traverse from source to destination
		adj.get(1).add(3);
		
		
		//if the given graph is directed graph then adding both the directions are not required 
		
		// add 3 to 5
		adj.get(3).add(5);
		
		
		
		//add 7 to 5
		adj.get(7).add(5);
		
		
		
		// print the adjacency List 
		
		for(int i= 1; i <= 9 ; i++) {
			for(int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(i+ " is connected to "+adj.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
}
