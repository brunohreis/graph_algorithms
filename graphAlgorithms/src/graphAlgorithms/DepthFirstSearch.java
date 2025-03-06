package graphAlgorithms;

public class DepthFirstSearch extends Search {
	private int[] discoveryTime;
	private int[] finishTime;
	private int[] father;
	private int time;
	DepthFirstSearch(Graph graph) {
		super(graph);
		int length = graph.getAdjMatrix().length;
		discoveryTime = new int[length];
		finishTime = new int[length];
		father = new int[length];
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
	public void search() {
		// The search root is always 0
		search(0);
	}
	private void search(int v) {
		discoveryTime[v] = ++time;
		int[] neighbors = graph.getNeighbors(v);
		for(int i=0; i<neighbors.length; i++) {
			int w = neighbors[i];
			if(discoveryTime[w] == 0) {
				// if the vertex w is visited for the first time
				
				// the tree edge explored
				edges.add(new Edge(v, w, false));
				
				father[w] = v;
				search(w);
			}
			else if(finishTime[w] != 0 && father[w] != v) {
				// if w is ancestor of v but not the father
				
				// the returning edge is explored
				edges.add(new Edge(v, w, true));
			}
		}
		finishTime[v] = ++time;
	}
}
