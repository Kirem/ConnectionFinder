package main;

import java.util.ArrayList;

import objects.TimeTable;

import com.google.gson.Gson;

public class ConnectionFinder {
	ArrayList<TimeTable> timeTable;
	
	public ConnectionFinder(){
		timeTable = new ArrayList<TimeTable>();
		
	}
	public static void main(String[] args) {

//		Stop stop = new Stop(1234, "sample");
//		Stop stopEnd = new Stop(12345, "sample1");
//		TransportLine transport = new TransportLine(TransportType.Bus, 112);
		/*
		 * lines.add(transport); lines.add(transport); lines.add(transport);
		 * lines.add(transport); Type type = new
		 * TypeToken<ArrayList<TransportLine>>(){}.getType(); String temp0 = new
		 * Gson().toJson(stop); System.out.println(temp0); String temp = new
		 * Gson().toJson(lines, type); System.out.println(temp); lines = new
		 * Gson().fromJson(temp, type);
		 * System.out.println(transport.toString()); Connection con = new
		 * Connection(lines, stop, stopEnd); con.addLine(transport);
		 * 
		 * String temp1 = new Gson().toJson(con); System.out.println(temp1);
		 * 
		 * File fLines = new File("jsonLines.txt"); File fConnection = new
		 * File("jsonConnection.txt"); File fStops = new File("jsonStops.txt");
		 * FileWriter fileWriter; try { fileWriter = new FileWriter(fLines);
		 * BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); try {
		 * bufferedWriter.write(temp); } finally { bufferedWriter.close(); } }
		 * catch (IOException e) { e.printStackTrace(); } try { fileWriter = new
		 * FileWriter(fConnection); BufferedWriter bufferedWriter = new
		 * BufferedWriter(fileWriter); try { bufferedWriter.write(temp1); }
		 * finally { bufferedWriter.close(); } } catch (IOException e) {
		 * e.printStackTrace(); } try { fileWriter = new FileWriter(fStops);
		 * BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); try {
		 * bufferedWriter.write(temp0); } finally { bufferedWriter.close(); } }
		 * catch (IOException e) { e.printStackTrace(); }
		 */
//		ArrayList<TransportLine> lines = new ArrayList<TransportLine>();
//
//		DataLoader dataLoader = new DataLoader();
//		try {
//			lines = dataLoader.loadLines("jsonLines.txt");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		for (TransportLine line : lines) {
//			System.out.println(line.toString());
//		}
		
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(5);
		test.add(5);
		test.add(5);
		TimeTable table = new TimeTable(1,1,test,test);
		ArrayList<TimeTable> timetables = new ArrayList<>();
		timetables.add(table);
		timetables.add(table);
		timetables.add(table);
		System.out.println(new Gson().toJson(timetables));
	}

}
