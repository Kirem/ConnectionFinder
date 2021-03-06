package routing;

import java.util.ArrayList;

public class Vertex {
	private int id;
    private ArrayList<Integer> neighbours;

    public Vertex(int id) {
        this.id = id;
        neighbours = new ArrayList<>();
    }

    public void addNeighbour(Vertex neighbour){
        neighbours.add(neighbour.getId());
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getNeighbours(){
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex) {
            return this.id == ((Vertex) o).id;
        }
        return false;
    }
}
