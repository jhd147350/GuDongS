package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicDao {
	protected Connection con;
	protected Statement stm;
	protected PreparedStatement pstm;
	protected ResultSet rs;
	
	protected String tableName;
	
	protected void close() throws SQLException{
		if(rs  !=null) {rs.close();}
		if(stm !=null) {stm.close();}
		if(pstm!=null) {pstm.close();}
		if(con !=null) {con.close();}
	}

}
