package graphAlgorithms;

import java.util.LinkedList;

public class BreadthFirstSearch extends Search {
	
	private int[] l;
	private int[] level;
	private int[] father;
	private int time;
	private LinkedList<Integer> queue;
	
	BreadthFirstSearch(Graph graph) {
		super(graph);
		int vCount = graph.getvCount();
		l = new int[vCount];
		level = new int[vCount];
		father = new int[vCount];
		queue = new LinkedList<Integer>();
		time = 0;
	}

	public int[] getL() {
		return l;
	}

	public int[] getLevel() {
		return level;
	}

	public int[] getFather() {
		return father;
	}

	public LinkedList<Integer> getQueue() {
		return queue;
	}

	@Override
	void search() {
		for(int i=0; i<l.length; i++) {
			if(l[i] == 0) {
				l[i] = ++time;
				queue.add(i);
				breadthFirstSearch();
			}
		}
	}
	void breadthFirstSearch() {
		while(!queue.isEmpty()) {
			int v = queue.remove();
			LinkedList<Integer> neighbors = graph.getNeighbors(v);
			for(int w : neighbors) {
				if(l[w] == 0) {
					// The father edge is visited
					edges.add(new Edge(v, w, EdgeType.fatherEdge));
					father[w] = v;
					level[w] = level[v] + 1;
					l[w] = ++time;
					queue.add(w);
				}
				else if(level[w] == level[v] + 1) {
					// The uncle edge is explored
					edges.add(new Edge(v, w, EdgeType.uncleEdge));
				}
				else if(level[w] == level[v] && father[w] == father[v] && l[w] > l[v]) {
					// The brother edge is visited
					edges.add(new Edge(v, w, EdgeType.brotherEdge));
				}
				else if(level[w] == level[v] && father[w] != father[v] && l[w] > l[v]) {
					// The cousin edge is visited
					edges.add(new Edge(v, w, EdgeType.cousinEdge));
				}
			}
		}
	}

}
