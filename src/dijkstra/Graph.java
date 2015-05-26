package dijkstra;

import java.util.ArrayList;
import java.util.List;

import objects.Timetable;
import objects.Week;

public class Graph {
	private ArrayList<Vertex> vertexes;
	private ArrayList<Edge> edges;

	public Graph() {
		vertexes = new ArrayList<>();
		edges = new ArrayList<>();
	}

	public void addEdge(Vertex vertex1, Vertex vertex2, double dist,
			int edgeId, Timetable tt, boolean se)
			throws IllegalArgumentException {

		if (!(vertexes.contains(vertex1) && vertexes.contains(vertex2))) {
			throw new IllegalArgumentException(
					"List vertexes doesn't contain at least one vertex");
		}
		vertex1 = vertexes.get(vertexes.indexOf(vertex1));
		vertex2 = vertexes.get(vertexes.indexOf(vertex2));

		Edge edge = new Edge(vertex1, vertex2, edgeId, dist, tt, se);
		edges.add(edge);
		vertex1.addNeighbour(vertex2);
		// vertex2.addNeighbour(vertex1);
	}

	public void addReverseEdge(Vertex vertex1, Vertex vertex2, double dist,
			int edgeId, Timetable tt, boolean sameEdge)
			throws IllegalArgumentException {

		if (!(vertexes.contains(vertex1) && vertexes.contains(vertex2))) {
			throw new IllegalArgumentException(
					"List vertexes doesn't contain at least one vertex");
		}
		vertex1 = vertexes.get(vertexes.indexOf(vertex1));
		vertex2 = vertexes.get(vertexes.indexOf(vertex2));

		Edge edge = new ReverseEdge(vertex1, vertex2, edgeId, dist, tt,
				sameEdge);
		edges.add(edge);
		vertex1.addNeighbour(vertex2);
		// vertex2.addNeighbour(vertex1);
	}

	public void setEdgeMultiplier(int edgeId, double multiplier) {
		for (Edge e : edges) {
			if (e.getId() == edgeId) {
				e.setMultiplier(multiplier);
			}
		}
	}

	public void resetMultiplierForEdges() {
		for (Edge e : edges) {
			e.setMultiplier(1);
		}
	}

	public void addVertex(Vertex vertexId) {
		if (!vertexes.contains(vertexId))
			vertexes.add(vertexId);
	}

	public int getNumberOfVertexes() {
		return vertexes.size();
	}

	public ArrayList<Vertex> getVertexes() {
		return vertexes;
	}

	public List<Integer> getNeighboursForVertex(int vertexId) {
		Vertex tem = new Vertex(vertexId, -1);
		if (vertexes.indexOf(tem) == -1) {
			return new ArrayList<>();
		}
		return vertexes.get(vertexes.indexOf(tem)).getNeighbours();
	}

	public double getEdgeDistance(int vertex1, int vertex2, int currTime,
			Week weekDay) {
		Vertex v1 = new Vertex(vertex1, -1);
		Vertex v2 = new Vertex(vertex2, -1);

		Edge tempEdge = new Edge(vertexes.get(vertexes.indexOf(v1)),
				vertexes.get(vertexes.indexOf(v2)), 0, 0, null, false);
		for (Edge edge : edges) {
			if (edge.equals(tempEdge)) {
				return edge.getDistance(currTime, weekDay);
			}
		}
		return -1;
	}

	public double getEdgeDistance(int id) {

		for (Edge edge : edges) {
			if (edge.getId() == id) {
				return edge.getDistance();
			}
		}
		return -1;
	}

	public List<Vertex> getVertexesForStopId(int stopId) {
		List<Vertex> stops = new ArrayList<Vertex>();
		for (Vertex vertex : vertexes) {
			if (vertex.getStopId() == stopId) {
				stops.add(vertex);
			}
		}
		return stops;
	}

	public int getLineNumber(int vertex1, int vertex2, int currTime,
			Week weekDay) {
		Vertex v1 = new Vertex(vertex1, -1);
		Vertex v2 = new Vertex(vertex2, -1);

		Edge tempEdge = new Edge(vertexes.get(vertexes.indexOf(v1)),
				vertexes.get(vertexes.indexOf(v2)), 0, 0, null, false);
		for (Edge edge : edges) {
			if (edge.equals(tempEdge)) {
				return edge.timetable.getLineNumber();
			}
		}
		return -1;
	}

	public Vertex getVertex(int which) {
		return vertexes.get(which);
	}

	public String toString() {
		String str = new String();
		for (Edge e : edges) {
			str += e.getVertex1Id() + "-" + e.getVertex2Id() + ":"
					+ e.getDistance() + "\n";
		}
		return str;
	}
}
