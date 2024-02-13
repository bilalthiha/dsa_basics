package AdjacencyMatrix;

public class AdjacencyMatrix {

	public static void main(String[] args) {

		//The graph in this example is a directed graph (->)
		
		// Adjacency Matrix = An array to store 1's/0's to represent edges
		//				       # of rows =    # of unique nodes
		//				       # of columns = # of unique nodes
			
		//					  runtime complexity to check an Edge: O(1)
		//					  space complexity: O(v^2)
		
		Graph graph = new Graph(5);
		Node n0 = new Node('A');
		Node n1 = new Node('B');
		Node n2 = new Node('C');
		Node n3 = new Node('D');
		Node n4 = new Node('E');
		
		graph.addNode(n0);
		graph.addNode(n1);
		graph.addNode(n2);
		graph.addNode(n3);
		graph.addNode(n4);
		
		graph.addEdge(n0, n1);
		graph.addEdge(n1, n2);
        graph.addEdge(n1, n4); // I forgot this line in the video
		graph.addEdge(n2, n3);
		graph.addEdge(n2, n4);
		graph.addEdge(n4, n0); //the forward direction is connected
		graph.addEdge(n4, n2);
		
		graph.print();
		
		System.out.println(graph.checkEdge(n0, n4)); //the reverse direction is not connected
	}
}




