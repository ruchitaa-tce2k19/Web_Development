package com.registration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class RegisterDao {
	private String dburl = "jdbc:postgresql://localhost/userdb";	 
	private String dbUname = "postgres";
	private String dbPassword = "admin";
	private String dbDriver = "org.postgresql.Driver";
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {			 
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dburl,dbUname,dbPassword);
		} catch (SQLException e) {			 
			e.printStackTrace();
		} catch (ClassNotFoundException e) {			 
			e.printStackTrace();
		}
		return con;
	}	
	public String insert(Member member) {		 
		Connection con = getConnection();
		String result = "Data entered successfully";
		String sql = "insert into member values(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getUname());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getEmail());
			ps.setString(4, member.getPhone());
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			result = "Data not entered";
		}		 
		return null;
	}
}
