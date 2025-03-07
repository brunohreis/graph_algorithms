package graphAlgorithms;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph("graphs/graph1.txt");
		DepthFirstSearch dfs = new DepthFirstSearch(graph);
		dfs.search();
		LinkedList<Edge> edges = dfs.getEdges();
		System.out.println("Depth First Search output: ");
		for(Edge edge : edges) {
			System.out.println(edge.toString());
		}
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
		bfs.search();
		edges = bfs.getEdges();
		System.out.println("Breadth First Search output: ");
		for(Edge edge : edges) {
			System.out.println(edge.toString());
		}
	}

}
