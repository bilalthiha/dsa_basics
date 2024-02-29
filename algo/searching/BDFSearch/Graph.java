package BDFSearch;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	ArrayList<Node> nodes;
	int[][] matrix;
	
	Graph(int size){
		
		nodes = new ArrayList<>();
		matrix = new int[size][size];
	}
	public void addNode(Node node) {
		
		nodes.add(node);
	}	
	public void addEdge(int src, int dst) {
		
		matrix[src][dst] = 1;
	}	
	public boolean checkEdge(int src, int dst) {
		
		if(matrix[src][dst] == 1) {
			return true;
		}
		else {
			return false;
		}
	}	
	public void print() {
		
		System.out.println("This is the graph under test..");
		
		System.out.print("  ");
		for(Node node : nodes) {
			System.out.print(node.data + " ");
		}
		System.out.println();
		
		for(int i = 0; i < matrix.length; i++) {
			System.out.print(nodes.get(i).data + " ");
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

    public void depthFirstSearch(int src){
		Stack<Integer> path = new Stack<>();
        boolean[] visited = new boolean[matrix.length];

		System.out.println("\nDepth First Search Algorithm's Output:");

		int curr = src;
		path.push(curr);
		visited[curr] = true;
		System.out.println(nodes.get(curr).data + " = visited");

		while(curr != -1){ //traverse until no where else to visit
			//traverse to the next node
			int i = 0;
			boolean found = false;
			while(i < matrix[curr].length && !found){ //found used because traverse to the first seen (1) node
				if(matrix[curr][i] == 1 && visited[i] == false){
					curr = i;
					path.push(curr);					
					visited[curr] = true;
					found = true;

					System.out.println(nodes.get(curr).data + " = visited");
				}
				i++;
			}

			//backtrack if no next node is found
			if(!found){
				if(path.isEmpty()){
					curr = -1; //no where else to go
				}
				else{
					curr = path.pop();
				}
								
			}			
		}
    }

	public void breadthFirstSearch(int src) {
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[matrix.length];

		System.out.println("\nBreadth First Search Algorithm's Output:");
		
		queue.offer(src);
		visited[src] = true;
		
		while(queue.size() != 0) {
			
			src = queue.poll();
			System.out.println(nodes.get(src).data + " = visited");
			
			for(int i = 0; i < matrix[src].length; i++) {
				if(matrix[src][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}


    /*The following is recursive algorithm and commented out for reference. */	
	// public void depthFirstSearch(int src) {
	// 	boolean[] visited = new boolean[matrix.length];
	// 	dFSHelper(src, visited);
	// }
	// private void dFSHelper(int src, boolean[] visited) {
		
	// 	if(visited[src]) {
	// 		return;
	// 	}
	// 	else {
	// 		visited[src] = true;
	// 		System.out.println(nodes.get(src).data + " = visited");
	// 	}
		
	// 	for(int i = 0; i < matrix[src].length; i++) {
	// 		if(matrix[src][i] == 1) {
	// 			dFSHelper(i, visited);
	// 		}
	// 	}
	// 	return;
	// }
}
