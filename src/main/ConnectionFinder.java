package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import objects.Connection;
import objects.Stop;
import objects.TransportLine;
import objects.TransportType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionFinder {

	public static void main(String[] args) {
		Stop stop1 = new Stop(1234, "sample");
		Stop stopEnd = new Stop(12345, "sample1");
		TransportLine transport = new TransportLine(TransportType.Bus, 112);
		ArrayList<TransportLine> lines = new ArrayList<TransportLine>();
		ArrayList<Connection> connections = new ArrayList<Connection>();
		ArrayList<Stop> stops = new ArrayList<Stop>();
		/*lines.add(transport);
		lines.add(transport);
		lines.add(transport);
		lines.add(transport);
		stops.add(stop1);
		stops.add(stopEnd);
		Type type = new TypeToken<ArrayList<TransportLine>>(){}.getType();
		Type typeConnection = new TypeToken<ArrayList<Connection>>(){}.getType();
		Type typeStop = new TypeToken<ArrayList<Stop>>(){}.getType();
		String temp0 = new Gson().toJson(stops, typeStop);
		System.out.println(temp0);
		String temp = new Gson().toJson(lines, type);
		System.out.println(temp);
		lines = new Gson().fromJson(temp, type);
		System.out.println(transport.toString());
		Connection con = new Connection(lines, stop1, stopEnd);
		con.addLine(transport);
		connections.add(con);
		
		String temp1 = new Gson().toJson(connections, typeConnection);
		System.out.println(temp1);
		
		File fLines = new File("jsonLines.txt");
		File fConnection = new File("jsonConnection.txt");
		File fStops = new File("jsonStops.txt");
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(fLines);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			try {
			    bufferedWriter.write(temp);
			} finally {
			    bufferedWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileWriter = new FileWriter(fConnection);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			try {
			    bufferedWriter.write(temp1);
			} finally {
			    bufferedWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileWriter = new FileWriter(fStops);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			try {
			    bufferedWriter.write(temp0);
			} finally {
			    bufferedWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		DataLoader dataLoader = new DataLoader();
		try {
			lines = dataLoader.loadLines("jsonLines.txt");
			connections = dataLoader.loadConnections("jsonConnection.txt");
			stops = dataLoader.loadStops("jsonStops.txt");
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
	}

}
