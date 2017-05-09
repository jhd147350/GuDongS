package db.dao;

import java.sql.SQLException;

import db.DBConnect;
import db.entity.User;

public class UserDao extends BasicDao {
	public UserDao() {
		// TODO Auto-generated constructor stub
		tableName="user";
	}
	
	public boolean Login(User u) throws SQLException {
		con = DBConnect.getConnection();
		if(con!=null){
			stm = con.createStatement();
			String sql="select * from "+tableName+" where username='"+u.getUsername()+"' and password='"+u.getPassword()+"';";
			rs = stm.executeQuery(sql);
			if(rs.next()){			
				if(!rs.next()){
					close();
					return true;
				}
			}
		}

		return false;
	}
	public boolean Signup(User user)  {
		String sql = "insert into "+tableName+"(username,password) values(?,?)";
		try {
			con=DBConnect.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setString( 1, user.getUsername());
			pstm.setString( 2, user.getPassword());
			pstm.execute();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
