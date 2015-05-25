package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.Week;

public class Dijkstra {
	private Map<Integer, Integer> pending;
	// private List<Integer> pending;
	private Map<Integer, Integer> precursor;
	private Map<Integer, Double> path;
	private List<Integer> result;
	private Map<Integer, Integer> changedLine;
	private Graph graph;
	private int justAdded, goal;
	private int startingTime;
	private Week weekDay;
	DijkstraResult dijkstraResult;
	private int start;
	private int time, lastLineNum, lineCounter;

	public Dijkstra(Graph g, int startingTime, Week day) {
		setGraph(g);
		precursor = new HashMap<>();
		path = new HashMap<>();
		pending = new HashMap<Integer, Integer>();
		changedLine = new HashMap<>();
		result = new ArrayList<>();
		this.startingTime = startingTime;
		this.weekDay = day;
		dijkstraResult = new DijkstraResult();
	}

	public DijkstraResult findShortestPath(int start, int end, boolean reversed, boolean notChangeLine) {
		clearIfExist();
		setLists();
		setTarget(start, end);
		while (!pending.isEmpty()) {
			System.out.println("Just added: " + justAdded);
			if(justAdded == -1){
				break;
			}
			for (int neighbour : graph.getNeighboursForVertex(justAdded)) {
				if (pending.containsKey(neighbour)) {
					int currTime;
					if (reversed) {
						currTime = (int) (startingTime - path.get(justAdded));
					} else {
						currTime = (int) (startingTime + path.get(justAdded));
					}
					double newPath = path.get(justAdded)
							+ graph.getEdgeDistance(justAdded, neighbour,
									currTime, weekDay);
					int currLineNum = graph.getLineNumber(justAdded, neighbour, currTime, weekDay);
					System.out.println("currtime: " + currTime + " new Path: "
							+ newPath + " currLine: " + currLineNum);
					
					if (notChangeLine) {
						if (lastLineNum == currLineNum) {
							setShorterPath(neighbour, newPath);
							if (neighbour == goal) {
								time = currTime;
							}
							break;
						}
					}
					if (path.get(neighbour) > newPath) {
						setShorterPath(neighbour, newPath);
						if (lastLineNum != currLineNum) {
							changedLine.put(neighbour, 1);
							lastLineNum = currLineNum;
						}
						if (neighbour == goal) {
							time = currTime;
						}
					}
				}
			}
			addNextVertex();
		}
		createSolution();
		dijkstraResult.path = result;
		dijkstraResult.time = time;
		dijkstraResult.interchangeNumber = lineCounter;
		return dijkstraResult;
	}

	public void setGraph(Graph g) {
		graph = g;
	}

	private void clearIfExist() {
		pending.clear();
		path.clear();
		precursor.clear();
		result.clear();
		changedLine.clear();
		lineCounter = 0;
	}

	private void setLists() {
		for (int i = 0; i < graph.getNumberOfVertexes(); i++) {
			precursor.put(graph.getVertex(i).getId(), -1);
			pending.put(graph.getVertex(i).getId(), i);
			path.put(graph.getVertex(i).getId(), Double.MAX_VALUE);
			changedLine.put(graph.getVertex(i).getId(), 0);
		}
	}

	private void setTarget(int start, int end) {
		pending.remove(start);
		path.put(start, 0.0);
		justAdded = start;
		this.start = start;
		goal = end;
	}

	private void setShorterPath(int neighbour, double newPath) {
		path.put(neighbour, newPath);
		precursor.put(neighbour, justAdded);
	}

	private void addNextVertex() {
		int smallest = findSmallestValue();
		pending.remove(smallest);
		System.out.println("found smallest:" + smallest);
		justAdded = smallest;
	}

	private int findSmallestValue() {
		double smallestValue = Double.MAX_VALUE;
		int index = -1;
		for (int next : pending.keySet()) {
			System.out.println("found smallest:" + path.get(next) + " for: " + next
					+ " smallest: " + smallestValue);
			if (path.get(next) < smallestValue) {
				smallestValue = path.get(next);
				index = next;
			}
		}
		return index;
	}

	private void createSolution() {
		int previous = goal;
		result.add(goal);
		while (precursor.get(previous) != -1) {
			result.add(precursor.get(previous));
			if (changedLine.get(previous) != 0) {
				lineCounter++;
			}
			previous = precursor.get(previous);
		}
	}
}
