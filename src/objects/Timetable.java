package objects;

import java.util.ArrayList;

public class Timetable {
	private int stopID;
	private int lineNumber;
	private ArrayList<Integer> normalDeparture;
	private ArrayList<Integer> weekendDeparture;

	public Timetable() {
		normalDeparture = new ArrayList<Integer>();
		weekendDeparture = new ArrayList<Integer>();
	}

	public Timetable(int id, int lineNum, ArrayList<Integer> normalDep,
			ArrayList<Integer> weekendDep) {
		this.stopID = id;
		this.lineNumber = lineNum;
		this.normalDeparture = new ArrayList<Integer>(normalDep);
		this.weekendDeparture = new ArrayList<Integer>(weekendDep);
	}

	public void setStopID(int id) {
		this.stopID = id;
	}

	public int getStopID() {
		return stopID;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setNormalDeparture(ArrayList<Integer> normalDep) {
		normalDeparture = normalDep;
	}

	public void setWeekendDeparture(ArrayList<Integer> weekendDep) {
		weekendDeparture = weekendDep;
	}

	public ArrayList<Integer> getNormalDeparture() {
		return normalDeparture;
	}

	public ArrayList<Integer> getWeekendDeparture() {
		return weekendDeparture;
	}

	public int getFirstTimeAfter(int minutes, Week whatDay) {
		switch (whatDay) {
		case FRIDAY:
			for (int time : normalDeparture) {
				if (time >= minutes) {
					return time;
				}
			}
			return weekendDeparture.get(0);
		case SATURDAY:
			for (int time : weekendDeparture) {
				if (time > minutes) {
					return time;
				}
			}
			return weekendDeparture.get(0);
		case SUNDAY:
			for (int time : weekendDeparture) {
				if (time >= minutes) {
					return time;
				}
			}
			return normalDeparture.get(0);
		default:
			for (int time : normalDeparture) {
				if (time >= minutes) {
					return time;
				}
			}
			return normalDeparture.get(0);
		}
	}

	public String toString() {
		StringBuilder normal = new StringBuilder();
		StringBuilder weekend = new StringBuilder();
		for (int time : normalDeparture) {
			normal.append(time + " , ");
		}
		for (int time : weekendDeparture) {
			weekend.append(time + " , ");
		}
		return "Stop ID: " + stopID + " Line nr: " + lineNumber
				+ "\nNormal Departure: " + normal.toString()
				+ "\nWeekend Departure: " + weekend.toString();
	}
}
