package dijkstra;

import java.util.ArrayList;

public class Vertex {
	private int id;
	private ArrayList<Integer> neighbours;
	private int stopId;

	public Vertex(int id, int stopId) {
		this.setStopId(stopId);
		this.id = id;
		neighbours = new ArrayList<>();
	}

	public void addNeighbour(Vertex neighbour) {
		neighbours.add(neighbour.getId());
	}

	public int getId() {
		return id;
	}

	public ArrayList<Integer> getNeighbours() {
		return neighbours;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Vertex) {
			return this.id == ((Vertex) o).id;
		}
		return false;
	}

	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopId) {
		this.stopId = stopId;
	}
}
