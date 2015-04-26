package dijkstra;

public class Edge {
	private Vertex vertex1, vertex2;
    private double distance, edgeMultiplier;
    private int edgeId;

    public Edge(Vertex v1, Vertex v2, int edgeId, double dis) {
        this.vertex1 = v1;
        this.vertex2 = v2;
        this.distance = dis;
        this.edgeMultiplier = 1;
    }

    public double getDistance() {
        return distance*edgeMultiplier;
    }

    public int getVertex1Id() {
        return vertex1.getId();
    }

    public int getVertex2Id() {
        return vertex2.getId();
    }

    public void setMultiplier(double multiplier){
        this.edgeMultiplier = multiplier;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Edge) {
        	//TODO return edgeId==edgeId?
            return ((this.vertex1.equals(((Edge) o).vertex1)
                    && this.vertex2.equals(((Edge) o).vertex2))
                    || (this.vertex1.equals (((Edge) o).vertex2)
                    && this.vertex2.equals(((Edge) o).vertex1)));
        }
        return false;
    }

	public int getId() {
		return edgeId;
	}
}
