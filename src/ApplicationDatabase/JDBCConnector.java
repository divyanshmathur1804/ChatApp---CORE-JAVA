package ApplicationDatabase;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import LoginSystem.utils.ConfigReader;
public class JDBCConnector {
	Connection con;
	String name = " ";
	public JDBCConnector() {
		try {
		Class.forName(ConfigReader.getValue("Driver"));
        String url = ConfigReader.getValue("CONNECTION_URL");
        String username = ConfigReader.getValue("USERID");
        String pass = ConfigReader.getValue("PASSWORD");
        con = DriverManager.getConnection(url, username, pass);
        
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}
	public void InsertData(String q,String data1,String data2,String data3) {
		try {
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setString(1, data1);
			pstmt.setString(2, data2);
			pstmt.setString(3,data3);
			pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean getData(String q) {
		try {
		java.sql.Statement stmt = con.createStatement();
		ResultSet set = stmt.executeQuery(q);
		if (set.next()) {
			name = set.getString(2);
			GetName(name);
			return true;
		}
		else {
			return false;
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return false;
	}
	public String GetName(String q) {
		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			if (set.next()) {
				name = set.getString(2);
				return name;


			}
			else {
				return " ";
			}	
		} catch (Exception e) {
			e.getStackTrace();
		}
		return " ";
	}

}
