package AdjacencyMatrix;
import java.util.ArrayList;

public class Graph {

	ArrayList<Node> nodes;
	int[][] matrix;
	int nodesSize;	
	
	Graph(int size){
		nodes = new ArrayList<>();
		matrix = new int[size][size];
		this.nodesSize = size;					
	}
	
	public void addNode(Node node) {
		if(nodes.size() <= nodesSize){
			nodes.add(node);	
		}			
	}
	
	public void addEdge(Node src, Node dst) {
		int srcId = src.id;
		int dstId = dst.id;
		matrix[srcId][dstId] = 1;		
	}

	public void removeEdge(Node src, Node dst) {
		int srcId = src.id;
		int dstId = dst.id;
		matrix[srcId][dstId] = 0;		
	}
	
	public boolean checkEdge(Node src, Node dst) {
		int srcId = src.id;
		int dstId = dst.id;
		return (matrix[srcId][dstId] == 1);				
	}
	
	public void print() {
		int row = 0;

		//Print col headers
		System.out.print("  ");
		for(Node n: nodes){
			System.out.print(n.data + " ");
		}
		System.out.println();

		//Pring row headers + rows
		for(Node n: nodes){
			
			System.out.print(n.data + " ");

			for(int col=0; col < nodesSize; col++){
				System.out.print(matrix[row][col] + " ");
			}
			row++;
			System.out.println();
		}		
	}
}
