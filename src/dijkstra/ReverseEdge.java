package dijkstra;

import objects.Timetable;
import objects.Week;

public class ReverseEdge extends Edge {

	public ReverseEdge(Vertex v1, Vertex v2, int edgeId, double dis,
			Timetable tt) {
		super(v1, v2, edgeId, dis, tt);
	}

	@Override
	public double getDistance(int currTime, Week day) {
//		System.out.println("reverse edge");
		return currTime - timetable.getFirstTimeBefore(currTime, day) + distance;
	}

}
