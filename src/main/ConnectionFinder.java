package main;

import java.lang.reflect.Type;
import java.util.ArrayList;

import objects.Stop;
import objects.TransportLine;
import objects.TransportType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionFinder {

	public static void main(String[] args) {
		Stop stop = new Stop(1234, "sample");
		TransportLine transport = new TransportLine(TransportType.Bus, 112);
		ArrayList<TransportLine> lines = new ArrayList<TransportLine>();
		lines.add(transport);
		lines.add(transport);
		lines.add(transport);
		lines.add(transport);
		Type type = new TypeToken<ArrayList<TransportLine>>(){}.getType();
		System.out.println(new Gson().toJson(stop));
		System.out.println(new Gson().toJson(lines, type));
	}

}
