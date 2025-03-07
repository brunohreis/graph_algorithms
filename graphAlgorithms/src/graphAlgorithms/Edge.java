package graphAlgorithms;

public class Edge {
	private int beggining;
	private int ending;
	// false = father edge, true = returning edge;
	private EdgeType type;
	Edge(int beggining, int ending, EdgeType type){
		this.beggining = beggining;
		this.ending = ending;
		this.type = type;
	}
	public int getBeggining() {
		return beggining;
	}
	public void setBeggining(int beggining) {
		this.beggining = beggining;
	}
	public int getEnding() {
		return ending;
	}
	public void setEnding(int ending) {
		this.ending = ending;
	}
	public EdgeType getType() {
		return type;
	}
	public void setType(EdgeType type) {
		this.type = type;
	}
	public String toString() {
		String s = new String();
		switch(type) {
			case brotherEdge:
				s = "Brother edge";
				break;
			case cousinEdge:
				s = "Cousin edge";
				break;
			case fatherEdge:
				s = "Father edge";
				break;
			case returningEdge:
				s = "Returning edge";
				break;
			case uncleEdge:
				s = "Uncle edge";
				break;
			default:
				break;
		}
		return  s + "\t{" + beggining + ", " + ending + "}";
	}
}
