package objects;

import java.util.ArrayList;

public class Connection {
	private ArrayList<TransportLine> lines;
	private Stop startingStop;
	private Stop endingStop;
	private int timeOfTravel;
	private int id;

	public Connection() {
		lines = new ArrayList<TransportLine>();
	}

	public Connection(ArrayList<TransportLine> lines, Stop start, Stop end,
			int dist, int id) {
		this.lines = new ArrayList<TransportLine>(lines);
		this.startingStop = start;
		this.endingStop = end;
	}

	public Connection(Stop start, Stop end) {
		lines = new ArrayList<TransportLine>();
		this.startingStop = start;
		this.endingStop = end;
	}

	public void addLine(TransportLine line) {
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

	public String toString() {
		return "Start: " + startingStop.toString() + "\nStop: "
				+ endingStop.toString() + "\ntime: " + timeOfTravel;
	}

	public int getTimeOfTravel() {
		return timeOfTravel;
	}

	public void setTimeOfTravel(int timeOfTravel) {
		this.timeOfTravel = timeOfTravel;
	}

	public int getConnectionID() {
		return id;
	}
}
