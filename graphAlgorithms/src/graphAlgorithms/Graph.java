package graphAlgorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Graph {
	
	private int[][] adjMatrix;
	
	Graph(String filename){
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			// If the representation is an adjacency matrix
			if(line != null && line.equals("Adjacency Matrix")) {
				line = br.readLine();
				int vCount, j = 0;
				if(line != null) {
					vCount = line.length();
					adjMatrix = new int[vCount][vCount];
					do {
						for(int i = 0; i < vCount; i++) {
							adjMatrix[j][i] = line.charAt(i) - 48;
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
	
	public int[][] getAdjMatrix(){
		return adjMatrix;
	}
	
	public int[] getNeighbors(int vertex) {
		int[] neighbors, aux;
		aux = new int[adjMatrix.length];
		int count = 0;
		for(int i=0; i<adjMatrix.length; i++) {
			if(adjMatrix[vertex][i] == 1) {
				aux[count] = i;
				count++;
			}
		}
		neighbors = new int[count];
		for(int i=0; i<count; i++) {
			neighbors[i] = aux[i];
		}
		
		return neighbors;
	}
}
