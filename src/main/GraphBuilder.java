package main;

import java.util.ArrayList;

import objects.Connection;
import objects.Timetable;
import objects.TransportLine;
import dijkstra.Graph;
import dijkstra.Vertex;

public class GraphBuilder {
	public static Graph build(ArrayList<Connection> connections, ArrayList<Timetable> times){
		Graph graph = new Graph();
		for(Connection connection : connections){
			for(TransportLine line : connection.getLinesArray()){
				Vertex vert = new Vertex(connection.getStartingStop().getStopID() * line.getNumber());
				Vertex vert2 = new Vertex(connection.getEndingStop().getStopID()*line.getNumber());
				System.out.println(connection);
				System.out.println(line);
				Timetable table = new Timetable(connection.getStartingStop().getStopID(), line.getNumber());
				int pos = times.indexOf(table);
				table = times.get(pos);
				graph.addVertex(vert);
				graph.addVertex(vert2);
				graph.addEdge(vert, vert2, connection.getTimeOfTravel(), pos, table);
			}
			
		}
		return graph;
		
	}
}
