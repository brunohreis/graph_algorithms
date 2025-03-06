package graphAlgorithms;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph("graphs/graph1.txt");
		DepthFirstSearch search = new DepthFirstSearch(graph);
		search.search();
		LinkedList<Edge> edges = search.getEdges();
		for(Edge edge : edges) {
			System.out.println(edge.toString());
		}
	}

}
