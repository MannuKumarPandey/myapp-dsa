package binarytrees;

public class TreeNodeCreation {
	
	public static class Node {
		int data;
		Node lChild;
		Node rChild;
		Node(int data, Node left, Node right){
			this.data = data;
			this.lChild = left;
			this.rChild = right;
		}
		Node(int data){
			this.data = data;
		}
	}

	public static void main(String[] args) {

		Node newNode = new Node(1000);
		System.out.println(newNode.data+"  "+ newNode.lChild+" "+newNode.rChild);
		
	}

}
