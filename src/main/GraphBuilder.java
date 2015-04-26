package main;

import java.util.ArrayList;

import objects.Connection;
import objects.Stop;
import objects.TimeTable;
import objects.TransportLine;
import dijkstra.Graph;
import dijkstra.Vertex;

public class GraphBuilder {
	public static Graph build(ArrayList<Connection> connections, ArrayList<TimeTable> times, int minOfTheDay){
		Graph graph = new Graph();
		for(Connection connection : connections){
			Vertex vert = new Vertex(connection.getStartingStop().getStopID());
			Vertex vert2 = new Vertex(connection.getEndingStop().getStopID());
			for(TransportLine line : connection.getLinesArray()){
				TimeTable table = new TimeTable(connection.getStartingStop().getStopID(), line.getNumber());
				int pos = times.indexOf(table);
				table = times.get(pos);
				
			}
//			times.indexOf(arg0)
			graph.addVertex(vert);
			graph.addVertex(vert2);
			graph.addEdge(vert, vert2, connection.getTimeOfTravel(), connection.getConnectionID());

		}
		return null;
		
	}
}
