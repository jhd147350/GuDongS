package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import db.dao.TrackDao;
import db.entity.Track;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class TrackServlet
 */
@WebServlet("/track")
public class TrackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String str_action = request.getParameter("action");
		int action = Integer.parseInt(str_action);
		switch (action) {
		case AllActions.GET_TRACK:
			String username = request.getParameter("username");
			getTrack(username, response);
			break;
		case AllActions.ADD_TRACK:
			String trackJson = request.getParameter("tracks");
			Gson g = new Gson();
			List<Track> tracks = g.fromJson(trackJson, new TypeToken<List<Track>>() {
			}.getType());
			// addTrack(t);
			System.out.println("----来了"+tracks.size()+"条数据");
			for(Track temp:tracks){
				addTrack(temp);	
			}
			JSONObject jo=new JSONObject();	
			jo.put("isSuc", true);
			PrintWriter pw = response.getWriter();
			pw.print(jo.toString());
			pw.close();
			break;
		}
	}

	public void getTrack(String username, HttpServletResponse response) {
		TrackDao trackDao = new TrackDao();
		try {
			List<Track> data = trackDao.searchByUser(username);
			Gson gson = new Gson();
			String json = gson.toJson(data);
			PrintWriter pw = response.getWriter();
			pw.print(json);
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addTrack(Track t) {
		TrackDao trackDao = new TrackDao();
		trackDao.addTracks(t);

	}

}
