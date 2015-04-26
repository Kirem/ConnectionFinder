package objects;

import java.util.ArrayList;

public class Connection {
	private ArrayList<TransportLine> lines;
	private Stop startingStop;
	private Stop endingStop;
	private int connectionID;
	private int timeOfTravel;
	
	public Connection() {
		lines = new ArrayList<TransportLine>();
	}
	
	public Connection(ArrayList<TransportLine> lines, Stop start, Stop end, int id, int timeOfTravel) {
		this.lines = new ArrayList<TransportLine>(lines);
		this.startingStop = start;
		this.endingStop = end;
		this.setConnectionID(id);
		this.setTimeOfTravel(timeOfTravel);
	}
	
	public Connection(Stop start, Stop end) {
		lines = new ArrayList<TransportLine>();
		this.startingStop = start;
		this.endingStop = end;
	}
	
	public void addLine(TransportLine line){
		lines.add(line);
	}
	
	public Stop getEndingStop() {
		return endingStop;
	}

	public void setEndingStop(Stop endingStop) {
		this.endingStop = endingStop;
	}

	public Stop getStartingStop() {
		return startingStop;
	}

	public void setStartingStop(Stop startingStop) {
		this.startingStop = startingStop;
	}

	public ArrayList<TransportLine> getLinesArray() {
		return lines;
	}

	public void setLinesArray(ArrayList<TransportLine> lines) {
		this.lines = lines;
	}

	@Override
	public String toString() {
		System.out.println("Linie:");
		for(TransportLine line : lines){
			System.out.println(line);
		}
		System.out.println("Przystanek poczatkowy:");
		System.out.println(startingStop);
		
		System.out.println("Przystanek koncowy:");
		System.out.println(endingStop);

		return super.toString();
	}

	public int getTimeOfTravel() {
		return timeOfTravel;
	}

	public void setTimeOfTravel(int timeOfTravel) {
		this.timeOfTravel = timeOfTravel;
	}

	public int getConnectionID() {
		return connectionID;
	}

	public void setConnectionID(int connectionID) {
		this.connectionID = connectionID;
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Connection)obj).connectionID==this.connectionID;
	}
	
	
}
