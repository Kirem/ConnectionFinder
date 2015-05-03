package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.Week;

public class Dijkstra {
	private Map<Integer,Integer> pending;
//	private List<Integer> pending;
	private Map<Integer, Integer> precursor;
	private Map<Integer, Double> path;
	private List<Integer> result;
	private Graph graph;
	private int justAdded, goal;
	private int startingTime;
	private Week weekDay;

	public Dijkstra(Graph g, int startingTime, Week day) {
		setGraph(g);
		precursor = new HashMap<>();
		path = new HashMap<>();
		pending = new HashMap<Integer, Integer>();
		result = new ArrayList<>();
		this.startingTime = startingTime;
		this.weekDay = day;
	}

	public List<Integer> findShortestPath(int start, int end){
        clearIfExist();
        setLists();
        setTarget(start, end);
        while(!pending.isEmpty()){
        	System.out.println("Just added: " + justAdded);
            for(int neighbour: graph.getNeighboursForVertex(justAdded)){
                if(pending.containsKey(neighbour)) {
                	int currTime = (int) (startingTime + path.get(justAdded));
                	double newPath = path.get(justAdded) + graph.getEdgeDistance(justAdded, neighbour, currTime, weekDay);
                   if(path.get(neighbour)> newPath){
                       setShorterPath(neighbour, newPath);
                   }
                }
            }
            addNextVertex();
        }
        createSolution();
        return result;
    }

	public void setGraph(Graph g) {
		graph = g;
	}

	private void clearIfExist() {
		pending.clear();
		path.clear();
		precursor.clear();
		result.clear();
	}

	private void setLists() {
		for (int i = 0; i < graph.getNumberOfVertexes(); i++) {
			precursor.put(graph.getVertex(i).getId(), -1);
			pending.put(graph.getVertex(i).getId(), i);
			path.put(graph.getVertex(i).getId(), Double.MAX_VALUE);
		}
	}

	private void setTarget(int start, int end) {
		pending.remove(start);
		path.put(start, 0.0);
		justAdded = start;
		goal = end;
	}

	private void setShorterPath(int neighbour, double newPath) {
		path.put(neighbour, newPath);
		precursor.put(neighbour, justAdded);
	}

	private void addNextVertex() {
		int smallest = findSmallestValue();
		pending.remove(smallest);
		justAdded = smallest;
	}

	private int findSmallestValue() {
		double smallestValue = Double.MAX_VALUE;
		int index = -1;
		for (int next : pending.keySet()) {
			if (path.get(next) < smallestValue) {
				smallestValue = path.get(next);
				index = next;
			}
		}
		return index;
	}

	private void createSolution() {
		int previous = goal;
		while (precursor.get(previous) != -1) {
			result.add(precursor.get(previous));
			previous = precursor.get(previous);
		}
	}
}
