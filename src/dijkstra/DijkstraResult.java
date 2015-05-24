package dijkstra;

import java.util.ArrayList;
import java.util.List;

public class DijkstraResult {

	public List<Integer> path;
	public int time;
	public DijkstraResult() {
		this.path = new ArrayList<Integer>();
	}
	
	@Override
	public String toString() {
		return "Path: " + path + "\nTime: " + time; 
	}
}
