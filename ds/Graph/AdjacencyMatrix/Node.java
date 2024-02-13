package AdjacencyMatrix;

public class Node {

	char data;
	int id;
	static int currId = 0;
	
	Node(char data){
		this.data = data;
		this.id = currId;
		currId++;
	}
}
