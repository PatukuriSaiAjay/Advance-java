package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program1 {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/jdbc-ajay";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,username,password);
			
			Statement stmt=con.createStatement();
			
			ResultSet res=stmt.executeQuery("Select * from employee");
			
			while(res.next())
			{
				int id=res.getInt("id");
				String name=res.getString("name");
				String email=res.getString("email");
				String dept= res.getString("dept");
				int salary=res.getInt("salary");
				
				System.out.println(id+" "+name+" "+email+" "+dept+" "+salary);
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
