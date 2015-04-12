package main;

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
		Stop stop = new Stop(1234, "sample");
		Stop stopEnd = new Stop(12345, "sample1");
		TransportLine transport = new TransportLine(TransportType.Bus, 112);
		ArrayList<TransportLine> lines = new ArrayList<TransportLine>();
		lines.add(transport);
		lines.add(transport);
		lines.add(transport);
		lines.add(transport);
		Type type = new TypeToken<ArrayList<TransportLine>>(){}.getType();
		System.out.println(new Gson().toJson(stop));
		String temp = new Gson().toJson(lines, type);
		System.out.println(temp);
		lines = new Gson().fromJson(temp, type);
		System.out.println(transport.toString());
		Connection con = new Connection(lines, stop, stopEnd);
		con.addLine(transport);
		
		String temp1 = new Gson().toJson(con);
		System.out.println(temp1);
	}

}
