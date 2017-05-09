package db.entity;

import java.sql.SQLException;
import java.util.List;

import db.dao.TrackDao;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrackDao trackDao=new TrackDao();
		//List<Track> searchByUser = (List<Track>) trackDao.searchByUser("111");
		//System.out.println(searchByUser.toString());
		Track track=new Track();
		track.setUsername("111");
		track.setTimestamp("151515");
		track.setPoints("{\"test\":\"test02\"}");
		trackDao.addTracks(track);
		

	}

}
