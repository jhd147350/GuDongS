package db.entity;

public class Track {
	private int id;
	private String username;
	private String points;
	private String timestamp;
	private String timestamp_e;
	private String distance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTimestamp_e() {
		return timestamp_e;
	}

	public void setTimestamp_e(String timestamp_e) {
		this.timestamp_e = timestamp_e;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", username=" + username + ", points=" + points + ", timestamp=" + timestamp
				+ ", timestamp_e=" + timestamp_e + ", distance=" + distance + "]";
	}

	
	

	
}
