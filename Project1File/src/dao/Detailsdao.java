package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectionManager.ConnectionManager;
import model.Details;

public class Detailsdao {

		public void addDetails(Details d) throws ClassNotFoundException, SQLException
		{
			int studentid=d.getStudentid();
			String studentname=d.getStudentname();
			String course=d.getCourse();
			int fees=d.getFees();
			
			ConnectionManager conm = new ConnectionManager();
			Connection con = conm.establishConnection();
			
			String query = "insert into Details values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,studentid);
			ps.setString(2, studentname);
			ps.setString(3,course);
			ps.setInt(4,fees);
			
			ps.executeUpdate();
			
			conm.closeConnection();
		}
		public void display() throws ClassNotFoundException, SQLException
		{
			ConnectionManager conm = new ConnectionManager();
			Connection con = conm.establishConnection();
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Details");
			while(rs.next())
			{
				System.out.println(rs.getInt("studentid")+" | "+rs.getString("studentname")+" | "+rs.getString("course")+" | "+rs.getInt("fees"));
			}
		}
		public boolean updateDetails(Details d) throws ClassNotFoundException, SQLException
		{
			int studentid = d.getStudentid();
			int paidfee = d.getPaidfee();
			
			ConnectionManager conm = new ConnectionManager();
			Connection con = conm.establishConnection();
			
			PreparedStatement st = con.prepareStatement("select fees from Details where studentid = ?");
			st.setInt(1,studentid);
			
			ResultSet rs = st.executeQuery();
			//System.out.println(rs);
			rs.next();
			int inStock = rs.getInt(1);
			if(inStock>=paidfee)
			{
				st = con.prepareStatement("update Details set fees=? where studentid=?");
				st.setInt(1,(inStock-paidfee));
				st.setInt(2, studentid);
				st.executeUpdate();
				conm.closeConnection();
				return true;
			}
			else
				conm.closeConnection();
				return false;
		}
}
