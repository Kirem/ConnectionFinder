package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import objects.Connection;
import objects.Stop;
import objects.Timetable;
import objects.TransportLine;

public class DataLoader {
	private ArrayList<TransportLine> lines;
	private ArrayList<Connection> connections;
	private ArrayList<Stop> stops;
	private ArrayList<Timetable> timetable;
	private Type typeLine, typeConnection, typeStop, typeTimetable;
	
	public DataLoader(){
		lines = new ArrayList<TransportLine>();
		typeLine = new TypeToken<ArrayList<TransportLine>>(){}.getType();
		typeConnection = new TypeToken<ArrayList<Connection>>(){}.getType();
		typeStop = new TypeToken<ArrayList<Stop>>(){}.getType();
		typeTimetable = new TypeToken<ArrayList<Timetable>>(){}.getType();
	}
	
	public ArrayList<TransportLine> loadLines(String filePath) throws IOException{
		String linesString = loadDataToString(filePath);
		lines = new Gson().fromJson(linesString, typeLine);
		return lines;
	}
	
	public ArrayList<Connection> loadConnections(String filePath) throws IOException{
		String connectionsString = loadDataToString(filePath);
		connections = new Gson().fromJson(connectionsString, typeConnection);
		return connections;
	}
	
	public ArrayList<Stop> loadStops(String filePath) throws IOException{
		String stopsString = loadDataToString(filePath);
		stops = new Gson().fromJson(stopsString, typeStop);
		return stops;
	}
	
	public ArrayList<Timetable> loadTimetable(String filePath) throws IOException{
		String timeTableString = loadDataToString(filePath);
		timetable = new Gson().fromJson(timeTableString, typeTimetable);
		return timetable;
	}
	
	private String loadDataToString(String filePath) throws IOException{
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuilder json = new StringBuilder();
		
		String textLine = bufferedReader.readLine();
		  do {
		    json.append(textLine);
		  
		    textLine = bufferedReader.readLine();
		  } while(textLine != null);

		  bufferedReader.close();
		  return json.toString();
	}
}
