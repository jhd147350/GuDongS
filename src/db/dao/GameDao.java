package db.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnect;
import db.entity.Game;

public class GameDao extends BasicDao{
	
	public GameDao() {
		//game_join 是一个视图，方便查询比赛信息时，附带统计参加比赛的人数
		tableName="game_join";
	}
	
	public List<Game> getGame() throws SQLException{
		String sql="select * from "+tableName;
		List<Game> games=new ArrayList<Game>();
		con=DBConnect.getConnection();
		stm=con.createStatement();
		rs=stm.executeQuery(sql);
		
		while(rs.next()){
			Game game=new Game();
			game.setId(rs.getInt(1));
			game.setTitle(rs.getString(2));
			game.setDate(rs.getString(3));
			game.setTag(rs.getString(4));
			game.setImage(rs.getString(5));
			game.setDetails(rs.getString(6));
			game.setPeoplenum(rs.getInt(7));
			games.add(game);
		}
		close();
		return games;
		
	}

}
