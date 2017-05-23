package db.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnect;
import db.entity.Game;
import db.entity.MyGame;

public class MyGameDao extends BasicDao {

	public MyGameDao() {
		// game_join 是一个视图，方便查询比赛信息时，附带统计参加比赛的人数
		tableName = "user_game";
	}

	public List<MyGame> getGame(String username) throws SQLException {
		String sql = "select * from " + tableName + " where username ='" + username + "'";
		List<MyGame> games = new ArrayList<MyGame>();
		con = DBConnect.getConnection();
		stm = con.createStatement();
		rs = stm.executeQuery(sql);

		while (rs.next()) {
			MyGame game = new MyGame();
			game.setGame_id(rs.getInt(1));
			game.setUsername(rs.getString(2));
			game.setTitle(rs.getString(3));
			games.add(game);
		}
		close();
		return games;

	}

}
