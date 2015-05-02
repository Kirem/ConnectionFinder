package objects;

public class Stop {
	private int stopID;
	private String stopName;
	
	public Stop(int id, String name){
		stopID = id;
		this.stopName = name;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		return stopID == ((Stop)obj).stopID;
	}

	public int getStopID() {
		return stopID;
	}

	public void setStopID(int stopID) {
		this.stopID = stopID;
	}

	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}
	
	public String toString(){
		return "ID: " + stopID + " Name: " + stopName; 
	}
	
}
