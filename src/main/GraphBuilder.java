package main;

import java.util.ArrayList;

import objects.Connection;
import objects.Timetable;
import objects.TransportLine;
import dijkstra.Graph;
import dijkstra.Vertex;

public class GraphBuilder {
	public static Graph build(ArrayList<Connection> connections,
			ArrayList<Timetable> times) {
		Graph graph = new Graph();
		System.out.println();
		System.out.println();

		for (Connection connection : connections) {
			for (TransportLine line : connection.getLinesArray()) {
				Vertex vert = new Vertex(connection.getStartingStop()
						.getStopID() * line.getNumber(), connection
						.getStartingStop().getStopID());
				Vertex vert2 = new Vertex(connection.getEndingStop()
						.getStopID() * line.getNumber(), connection
						.getEndingStop().getStopID());
				// System.out.println(connection);
				Timetable table = new Timetable(connection.getStartingStop()
						.getStopID(), line.getNumber());
				int pos = times.indexOf(table);
				table = times.get(pos);

				// System.out.println(table);
				graph.addVertex(vert);
				graph.addVertex(vert2);
				graph.addEdge(vert, vert2, connection.getTimeOfTravel(), pos,
						table, false);
				for (TransportLine line1 : connection.getLinesArray()) {
					if (line != line1) {
						table = new Timetable(connection.getStartingStop()
								.getStopID(), line1.getNumber());
						pos = times.indexOf(table);
						table = times.get(pos);
						vert2 = new Vertex(connection.getStartingStop()
								.getStopID() * line1.getNumber(), connection
								.getStartingStop().getStopID());
						graph.addVertex(vert2);
						System.out.println(line);
						System.out.println(line1);
						graph.addEdge(vert, vert2, 0, pos, table, true);
					}
				}
			}

		}
		return graph;
	}

	public static Graph buildReverse(ArrayList<Connection> connections,
			ArrayList<Timetable> times) {
		Graph graph = new Graph();
		System.out.println();
		System.out.println();

		for (Connection connection : connections) {
			for (TransportLine line : connection.getLinesArray()) {
				Vertex vert2 = new Vertex(connection.getStartingStop()
						.getStopID() * line.getNumber(), connection
						.getStartingStop().getStopID());
				Vertex vert = new Vertex(connection.getEndingStop().getStopID()
						* line.getNumber(), connection.getStartingStop()
						.getStopID());
				// System.out.println(connection);
				Timetable table = new Timetable(connection.getStartingStop()
						.getStopID(), line.getNumber());
				int pos = times.indexOf(table);
				table = times.get(pos);

				// System.out.println(table);
				graph.addVertex(vert);
				graph.addVertex(vert2);
				graph.addReverseEdge(vert, vert2, connection.getTimeOfTravel(),
						pos, table, false);
				for (TransportLine line1 : connection.getLinesArray()) {
					if (line != line1) {
						table = new Timetable(connection.getStartingStop()
								.getStopID(), line1.getNumber());
						pos = times.indexOf(table);
						table = times.get(pos);
						vert = new Vertex(connection.getStartingStop()
								.getStopID() * line1.getNumber(), connection
								.getStartingStop().getStopID());
						graph.addVertex(vert);
						System.out.println(line);
						System.out.println(line1);
						graph.addReverseEdge(vert, vert2, 0, pos, table, true);
					}
				}
			}

		}
		return graph;
	}
}
