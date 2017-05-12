package db.entity;

public class Point {
	private String timestamp;
	private String la;
	private String lo;
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getLa() {
		return la;
	}
	public void setLa(String la) {
		this.la = la;
	}
	public String getLo() {
		return lo;
	}
	public void setLo(String lo) {
		this.lo = lo;
	}
	@Override
	public String toString() {
		return "Points [timestamp=" + timestamp + ", la=" + la + ", lo=" + lo + "]";
	}
	

}
