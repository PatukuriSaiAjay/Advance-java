
//write a program to delete the data through java program to database

package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program5 {
	
	public static void main(String args[])
	{
		
		Connection con =null;
		
		Statement stmt=null;
		
		String url="jdbc:mysql://localhost:3306/jdbc-ajay";
		String username="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url, username, password);
			
			String delete="delete from `employee` where `name`='nagendra'";
			
			stmt=con.createStatement();
			
			stmt.executeUpdate(delete);
			
			
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
