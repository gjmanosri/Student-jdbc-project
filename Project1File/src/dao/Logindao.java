package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectionManager.ConnectionManager;
import model.Login;

public class Logindao {

	public boolean loginValidation(Login l) throws ClassNotFoundException, SQLException
	{
		String username = l.getUsername();
		String pass = l.getPass();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from Login");
		while(rs.next())
		{
			if(username.equals(rs.getString("Username")) && pass.equals(rs.getString("Pass")))
			{
				conm.closeConnection();
				return true;
			}
		}
		conm.closeConnection();
		return false;
	}

}
