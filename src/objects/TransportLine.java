package objects;

public class TransportLine {
	private TransportType type;
	private int number;
	public TransportLine(TransportType type, int number) {
		this.setNumber(number);
		this.setType(type);
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public TransportType getType() {
		return type;
	}
	public void setType(TransportType type) {
		this.type = type;
	}
}
