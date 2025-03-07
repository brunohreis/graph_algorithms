package graphAlgorithms;

import java.util.LinkedList;

public class DepthFirstSearch extends Search {
	private int[] discoveryTime;
	private int[] finishTime;
	private int[] father;
	private int time;
	DepthFirstSearch(Graph graph) {
		super(graph);
		int vCount = graph.getvCount();
		discoveryTime = new int[vCount];
		finishTime = new int[vCount];
		father = new int[vCount];
		time = 0;
	}
	public int[] getDiscoveryTime() {
		return discoveryTime;
	}
	public int[] getFinishTime() {
		return finishTime;
	}
	public int[] getFather() {
		return father;
	}
	@Override
	public void search() {
		// As long as there is a vertex undiscovered, execute the search innit as the root
		for(int i=0; i<discoveryTime.length; i++) {
			if(discoveryTime[i] == 0) {
				search(i);
			}
		}
	}
	private void search(int v) {
		discoveryTime[v] = ++time;
		LinkedList<Integer> neighbors = graph.getNeighbors(v);
		for(int w : neighbors) {
			if(discoveryTime[w] == 0) {
				// if the vertex w is visited for the first time
				
				// the tree edge is explored
				edges.add(new Edge(v, w, EdgeType.fatherEdge));
				
				father[w] = v;
				search(w);
			}
			else if(finishTime[w] == 0 && w != father[v]) {
				// if w is ancestor of v but not the father
				
				// the returning edge is explored
				edges.add(new Edge(v, w, EdgeType.returningEdge));
			}
		}
		finishTime[v] = ++time;
	}
}
