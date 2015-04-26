package dijkstra;

import java.util.ArrayList;

public class Graph {
	private ArrayList<Vertex> vertexes;
	private ArrayList<Edge> edges;

	public Graph() {
		vertexes = new ArrayList<>();
		edges = new ArrayList<>();
	}

	public void addEdge(Vertex vertex1, Vertex vertex2, double dist, int edgeId)
			throws IllegalArgumentException {

		if (!(vertexes.contains(vertex1) && vertexes.contains(vertex2))) {
			throw new IllegalArgumentException(
					"List vertexes doesn't contain at least one vertex");
		}

		Edge edge = new Edge(vertex1, vertex2, edgeId, dist);
		edges.add(edge);
		vertex1.addNeighbour(vertex2);
		vertex2.addNeighbour(vertex1);
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
		vertexes.add(vertexId);
	}

	public int getNumberOfVertexes() {
		return vertexes.size();
	}

	public ArrayList<Vertex> getVertexes() {
		return vertexes;
	}

	public double getEdgeDistance(int vertex1, int vertex2) {
		Edge tempEdge = new Edge(vertexes.get(vertex1), vertexes.get(vertex2), 0, 0);
		for (Edge edge : edges) {
			if (edge.equals(tempEdge)) {
				return edge.getDistance();
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
