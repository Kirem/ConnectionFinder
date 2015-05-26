package dijkstra;

import java.util.ArrayList;
import java.util.List;

public class DijkstraResult {

	public List<Integer> path;
	public int time, interchangeNumber;
	public DijkstraResult() {
		this.path = new ArrayList<Integer>();
		time = Integer.MAX_VALUE;
	}
	
	@Override
	public String toString() {
		return "Path: " + path + "\nTime: " + time + "\nNumber of interchange: " + interchangeNumber; 
	}
}
