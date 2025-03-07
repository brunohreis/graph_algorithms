package graphAlgorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

public class Graph {
	
	private LinkedList<Integer>[] adjacencyLists;
	private int vCount;
	
	Graph(String filename){
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			// If the representation is an adjacency matrix
			if(line != null && line.equals("Adjacency Matrix")) {
				line = br.readLine();
				int j = 0;
				if(line != null) {
					vCount = line.length();
					adjacencyLists = new LinkedList[vCount];
					do {
						adjacencyLists[j] = new LinkedList<Integer>();
						for(int i = 0; i < vCount; i++) {
							if(line.charAt(i) - '0' == 1) {
								adjacencyLists[j].add(i);
							}
						}
						
						line = br.readLine();
						j++;
					} while(line != null);
					
				}
				else {
					return;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int getvCount() {
		return vCount;
	}


	public LinkedList<Integer>[] getAdjacencyLists() {
		return adjacencyLists;
	}


	public LinkedList<Integer> getNeighbors(int vertex) {
		return adjacencyLists[vertex];
	}
	
	public int getEdgesCount() {
		int edgesCount = 0;
		for(int i=0; i<adjacencyLists.length; i++) {
			edgesCount += adjacencyLists[i].size();
		}
		return edgesCount;
	}
}
