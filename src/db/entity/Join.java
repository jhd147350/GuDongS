package db.entity;

public class Join {
	private int game_id;
	private String username;
	private String score;

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Join [game_id=" + game_id + ", username=" + username + ", score=" + score + "]";
	}
}
