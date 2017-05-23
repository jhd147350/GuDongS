package db.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnect;
import db.entity.Join;

public class JoinDao extends BasicDao {
	public JoinDao() {
		// TODO Auto-generated constructor stub
		tableName = "join";
	}

	public int getPeopleNum(int game_id) throws SQLException {
		String sql = "select * from " + tableName + " where game_id = " + game_id;
		con = DBConnect.getConnection();
		stm = con.createStatement();
		rs = stm.executeQuery(sql);
		int i = 0;
		List<Join> joins = new ArrayList<Join>();
		while (rs.next()) {
			i++;
		}
		close();
		return i;
	}

	public boolean joinGame(int game_id, String username) {
		String sql = "insert into `" + tableName + "` (game_id,username) VALUES(?,?)";
		con = DBConnect.getConnection();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, game_id);
			pstm.setString(2, username);
			pstm.execute();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;

	}

}
