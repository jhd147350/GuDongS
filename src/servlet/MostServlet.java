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
import db.entity.Game;

/**
 * Servlet implementation class MostServlet
 */
@WebServlet("/most")
public class MostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");	
		
		String str_action =request.getParameter("action");
		int action=Integer.parseInt(str_action);
		switch (action) {
		case AllActions.GET_GAME:
			try {
				getGame(response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		}
	}
	
	
	public void getGame(HttpServletResponse response) throws SQLException, IOException{
		GameDao gameDao=new GameDao();
		List<Game> games = gameDao.getGame();
		PrintWriter writer = response.getWriter();
		Gson g=new Gson();
		String json = g.toJson(games);
		writer.println(json);
	}

}
