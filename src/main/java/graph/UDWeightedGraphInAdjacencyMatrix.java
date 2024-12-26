package graph;

public class UDWeightedGraphInAdjacencyMatrix {

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addUnDirectedEdge(0, 1, 45);
		graph.addUnDirectedEdge(0, 2, 5);
		graph.addUnDirectedEdge(1, 2, 500);
		graph.addUnDirectedEdge(3, 4, 55);
		graph.print();
	}
}
class Graph{
	int n; // number of nodes
	int adjMatrix[][];
	
	Graph(int numberOfNodes){
		n = numberOfNodes;
		adjMatrix = new int [n][n];
		// Creating two Dimensional Array with n*n because we need to have nth index accessed
	}
	
	public void addDirectedEdge(int source, int destination, int weight) {
		//In case of directed graph we need to only add one way direction of traversal
		adjMatrix[source][destination] = weight;
	}
	
	public void addUnDirectedEdge(int source, int destination, int weight) {
		//In case of undirected graph, we need to add both the directions of traversal
		addDirectedEdge(source, destination, weight);
		addDirectedEdge(destination, source, weight);
	}
	
	public void print() {
		for(int i = 0; i< n; i++) {
			System.out.print("vertex "+ i+" is connected to ");
			for(int j= 0; j<n; j++) {
				if(adjMatrix[i][j] != 0) {
					System.out.print("( "+j+" ,"+ adjMatrix[i][j]+" ) ");
				}
			}
			System.out.println();
			
		}
	}
}






