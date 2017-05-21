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

import db.dao.GameDao;
import db.dao.JoinDao;
import db.entity.Game;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class MostServlet
 */
@WebServlet("/most")
public class MostServlet extends HttpServlet {
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
		case AllActions.GET_GAME:
			try {
				getGame(response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case AllActions.JOIN:
			int game_id=Integer.parseInt(request.getParameter("game_id"));
			String username = request.getParameter("username");
			try {
				joinGame(game_id,username,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case AllActions.JOIN_NUM:
			int game_id1=Integer.parseInt(request.getParameter("game_id"));
			try {
				getJoinNum(game_id1, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
	}

	public void getGame(HttpServletResponse response) throws SQLException, IOException {
		GameDao gameDao = new GameDao();
		List<Game> games = gameDao.getGame();
		PrintWriter writer = response.getWriter();
		Gson g = new Gson();
		String json = g.toJson(games);
		writer.println(json);
		writer.close();
	}

	public void joinGame(int game_id, String username, HttpServletResponse response) throws SQLException, IOException {
		JoinDao joinDao = new JoinDao();
		boolean isSuc = joinDao.joinGame(game_id, username);
		JSONObject jo=new JSONObject();
		jo.put("isSuc", isSuc);
		System.out.println("-------------------------joinGame : "+isSuc+"---------------");
		PrintWriter pw = response.getWriter();
		pw.println(jo.toString());
		pw.close();
	}
	
	public void getJoinNum(int game_id,HttpServletResponse response) throws SQLException, IOException{
		JoinDao joinDAo=new JoinDao();
		int num=joinDAo.getPeopleNum(game_id);
		JSONObject jo=new JSONObject();
		jo.put("num", num);
		System.out.println("-------------------------getJoinNum : "+num+"---------------");
		PrintWriter pw = response.getWriter();
		pw.println(jo.toString());
		pw.close();
		
		
	}
	
	

}
