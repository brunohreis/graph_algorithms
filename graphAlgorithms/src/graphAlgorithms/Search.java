package graphAlgorithms;

import java.util.LinkedList;

public abstract class Search {
	protected Graph graph;
	LinkedList<Edge> edges;
	Search(Graph graph){
		this.graph = graph;
		edges = new LinkedList<Edge>();
	}
	public LinkedList<Edge> getEdges() {
		return edges;
	}
	abstract void search();
}
