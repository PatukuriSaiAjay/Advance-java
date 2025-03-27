package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program4 {

	public static void main(String[] args) {
		
		Connection con =null;
		
		Statement stmt=null;
		
		String url="jdbc:mysql://localhost:3306/jdbc-ajay";
		String username="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url, username, password);
			
			String update="update `employee` set `salary`=`salary`+5000 where `id`='6'";
			
			stmt=con.createStatement();
			
			stmt.executeUpdate(update);
			
			
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
