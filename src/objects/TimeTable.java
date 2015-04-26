package objects;

import java.util.ArrayList;

public class TimeTable {
	private int stopId;
	private int lineNumber;
	private ArrayList<Integer> normalDeparature;
	private ArrayList<Integer> weekendDeparature;

	public TimeTable() {
		normalDeparature = new ArrayList<Integer>();
		weekendDeparature = new ArrayList<Integer>();
	}

	public TimeTable(int stopId, int lineNumber) {
		this.stopId = stopId;
		this.lineNumber = lineNumber;
		normalDeparature = new ArrayList<Integer>();
		weekendDeparature = new ArrayList<Integer>();
	}	
	
	public TimeTable(int stopId, int lineNumber, ArrayList<Integer> normalDep, ArrayList<Integer> weekendDep) {
		this.stopId = stopId;
		this.lineNumber = lineNumber;
		normalDeparature = new ArrayList<Integer>(normalDep);
		weekendDeparature = new ArrayList<Integer>(weekendDep);
	}

	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopId) {
		this.stopId = stopId;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public ArrayList<Integer> getNormalDeparature() {
		return normalDeparature;
	}

	public void setNormalDeparature(ArrayList<Integer> normalDeparature) {
		this.normalDeparature = normalDeparature;
	}

	public ArrayList<Integer> getWeekendDeparature() {
		return weekendDeparature;
	}

	public void setWeekendDeparature(ArrayList<Integer> weekendDeparature) {
		this.weekendDeparature = weekendDeparature;
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((TimeTable) obj).lineNumber == this.lineNumber
				&& ((TimeTable) obj).stopId == this.stopId;
	}
}
