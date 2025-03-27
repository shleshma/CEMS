package event.management.systen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {
	 Connection conn;
	 Statement stm;
	 ResultSet rs;
	
	public Connect(){
		
		 try {
			 //connection for MySQL 
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/eventmgmt", "root","");
	            stm= conn.createStatement();
	        }
	        catch (Exception e) 
	        {
	          e.printStackTrace();
	        }
	}
}
