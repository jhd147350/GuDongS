package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.dao.UserDao;
import db.entity.User;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Sign
 * 注册登录都在这里完成
 */
@WebServlet("/sign")
public class SignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");	
		
		System.out.println("---------------------UserServlet:doGet---------------");
		String str_action =request.getParameter("action");
		int action=Integer.parseInt(str_action);
		switch (action) {
		case AllActions.LOGIN://
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			//JSONObject jo=new JSONObject(loginInfo);			
			Login(username,password,response);			
			break;
		case AllActions.SIGN_UP:
			String susername=request.getParameter("username");
			String spassword=request.getParameter("password");		
			System.out.println("---------------------UserServlet:doGet---");
			Signup(susername,spassword,response);	
		default:
			break;
		}
	}

	
	private void Signup(String username, String password,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		UserDao ud=new UserDao();
		JSONObject jo=new JSONObject();	
		try {
			User user=new User();
			user.setUsername(username);;
			user.setPassword(password);
			boolean isSuc = ud.Signup(user);
			jo.put("isSuc", isSuc);
			System.out.println("-------------------------sign up "+isSuc+"---------------");
			PrintWriter pw = response.getWriter();
			pw.println(jo.toString());
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-------------------------err---------------");
		}				
		
	}
	
	private void Login(String username,String password,HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.printf(""+username+":"+password);
		UserDao ud=new UserDao();
		//JSONObject jo=new JSONObject();
		
		
		JSONObject jo=new JSONObject();	
		try {
			User u=new User();
			u.setUsername(username);
			u.setPassword(password);
			boolean isSuc = ud.Login(u);			
			jo.put("isSuc", isSuc);
			System.out.println("-------------------------login "+isSuc+"---------------");
			PrintWriter pw = response.getWriter();
			pw.println(jo.toString());
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-------------------------err---------------");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("-------------------------err---------------");
		}		
	}


}
