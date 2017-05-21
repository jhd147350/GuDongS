package db.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnect;
import db.entity.Track;

public class TrackDao extends BasicDao{
	
	public TrackDao() {
		// TODO Auto-generated constructor stub
		tableName="track";
	}
	
	public List<Track> searchByUser(String username) throws SQLException{
		String sql="select * from "+tableName+" where username = "+username+";";
		List<Track> list=new ArrayList<Track>();
		con=DBConnect.getConnection();
		if(con!=null){
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){			
				Track t=new Track();
				t.setId(rs.getInt(1));
				t.setUsername(username);
				t.setTimestamp(rs.getString(3));
				t.setPoints(rs.getString(4));
				t.setTimestamp_e(rs.getString(5));
				
				list.add(t);
			}
			close();
		}
		return list;
	}
	
	public boolean addTracks(Track track){
		String sql="insert into "+tableName+"(username,timestamp,points,timestamp_e,distance) VALUES(?,?,?,?,?)";
		try {
			con=DBConnect.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString( 1, track.getUsername());
			pstm.setString(2, track.getTimestamp());
			pstm.setString(3,track.getPoints());
			pstm.setString(4, track.getTimestamp_e());
			pstm.setString(5, track.getDistance());
			pstm.execute();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
