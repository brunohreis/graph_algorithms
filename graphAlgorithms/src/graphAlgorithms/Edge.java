package graphAlgorithms;

public class Edge {
	private int beggining;
	private int ending;
	// false = father edge, true = returning edge;
	private boolean type;
	Edge(int beggining, int ending, boolean type){
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
	public boolean getType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public String toString() {
		String s = type?"Returning edge":"Father edge";
		return  s + "\t{" + beggining + ", " + ending + "}";
	}
}
