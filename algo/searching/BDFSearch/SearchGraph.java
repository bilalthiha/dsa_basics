package BDFSearch;

public class SearchGraph {

	public static void main(String[] args) {
		
		// Depth First Search = Pick a route, keep going.
		//					 If you reach a dead end, or an already visited node,
		//					 backtrack to a previous node with unvisited adjacent neighbors
		
		Graph graph = new Graph(5);
		
		graph.addNode(new Node('A')); //A -> 0
		graph.addNode(new Node('B')); //B -> 1
		graph.addNode(new Node('C'));
		graph.addNode(new Node('D'));
		graph.addNode(new Node('E')); //E -> 4
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 0);
		graph.addEdge(4, 2);
		
		graph.print();
		
		graph.depthFirstSearch(1);
		graph.breadthFirstSearch(1);
	}
}

