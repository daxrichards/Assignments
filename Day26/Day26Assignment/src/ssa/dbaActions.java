package ssa;

import java.awt.List;
import java.util.*;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class dbaActions {

	public Statement stmt = null;
	public Connection myConn = null;
	public PreparedStatement prepStmt = null;
	public ResultSet prepRs = null;
	public ResultSet rs = null;
	
	
	
	
//Connection is made to the database
	public void loadMe() throws SQLException {
		try {

			Properties props = new Properties();
			props.load(new FileInputStream("props.properties"));

			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String pwd = props.getProperty("pwrd");
			// props.load(new fileInputStream("c:/file/location")

			myConn = (Connection) DriverManager.getConnection(url, user, pwd);

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	
	//Method to return a ResultSet object
	public ResultSet executeQuery(String sql) throws SQLException {
 
        	
		
		loadMe();
		try {
			stmt = myConn.createStatement();
			
		
		}
       catch(Exception ex){
			ex.printStackTrace();
       }
	
		return	rs = stmt.executeQuery(sql);
	}
	
   //Method to format the results
	public void display(ResultSet rs) throws SQLException {

		System.out.format("\n%d %8s %8s %10.2f %5d", rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
				rs.getDouble("gpa"), rs.getInt("sat"));
	}

	public void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {

		if (conn != null)
			conn.close();
		if (stmt != null)
			stmt.close();
		if (rs != null)
			rs.close();

	}

	public void close(Connection conn, PreparedStatement stmt, ResultSet rs) throws SQLException {

		if (conn != null)
			conn.close();
		if (stmt != null)
			stmt.close();
		if (rs != null)
			rs.close();

	}
}