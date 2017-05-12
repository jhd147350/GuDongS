package db.entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.mysql.fabric.xmlrpc.base.Array;

import db.dao.TrackDao;

public class TestDB {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		TrackDao trackDao=new TrackDao();
		//List<Track> searchByUser = (List<Track>) trackDao.searchByUser("111");
		//System.out.println(searchByUser.toString());
		Track track=new Track();
		track.setUsername("111");
		track.setTimestamp("161616");
		track.setTimestamp_e("1515");
		List<Point> points=new ArrayList<>();
		Point p=new Point();
		p.setTimestamp("1511");
		p.setLa("1515");
		p.setLo("515");
		points.add(p);
		Gson g=new Gson();
		String json2 = g.toJson(points);
		System.out.println("points:"+json2);
		track.setPoints(json2);
		trackDao.addTracks(track);
		
		
		List<Track> data = trackDao.searchByUser("111");
		Gson gson=new Gson();
		String json = gson.toJson(data);
		System.out.println(data.toString());
		System.out.println(json);
		//JsonParser jp=new JsonParser();
		
		//JsonArray asJsonArray = jp.parse(json).getAsJsonArray();
		List<Track> fromJson = gson.fromJson(json, new TypeToken<List<Track>>() {  
        }.getType());
		System.out.println(fromJson.toString());
		

	}

}
