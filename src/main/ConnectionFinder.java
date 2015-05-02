package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import objects.Connection;
import objects.Stop;
import objects.Timetable;
import objects.TransportLine;
import objects.TransportType;
import objects.Week;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dijkstra.Dijkstra;
import dijkstra.Graph;

public class ConnectionFinder {

	public static void main(String[] args) {
		Stop stop1 = new Stop(1234, "sample");
		Stop stopEnd = new Stop(12345, "sample1");
		TransportLine transport = new TransportLine(TransportType.Bus, 112);
		ArrayList<TransportLine> lines = new ArrayList<TransportLine>();
		ArrayList<Connection> connections = new ArrayList<Connection>();
		ArrayList<Stop> stops = new ArrayList<Stop>();
		ArrayList<Timetable> timetable = new ArrayList<Timetable>();
		
		DataLoader dataLoader = new DataLoader();
		try {
			lines = dataLoader.loadLines("jsonLines.txt");
			connections = dataLoader.loadConnections("jsonConnection.txt");
			stops = dataLoader.loadStops("jsonStops.txt");
			timetable = dataLoader.loadTimetable("jsonTimeTable.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(TransportLine line: lines){
			System.out.println(line.toString());
		}
		for(Stop stop: stops){
			System.out.println(stop.toString());
		}
		for(Connection connection: connections){
			System.out.println(connection.toString());
		}
		for(Timetable table: timetable){
			System.out.println(table.toString());
		}
		
		new GraphBuilder();
		Graph graph = GraphBuilder.build(connections, timetable);
		System.out.println("Graph structure:");
		System.out.println(graph);
		System.out.println();
		System.out.println("Algorith result:");
		System.out.println(new Dijkstra(graph, 50, Week.MONDAY).findShortestPath(1, 3));


		

	}

}
