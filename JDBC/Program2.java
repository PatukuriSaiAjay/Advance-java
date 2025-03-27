package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {

	public static void main(String[] args) {
		
		
		Connection con= null;
		
		Statement stmt= null; 
		
		ResultSet res= null;
		
		String url="jdbc:mysql://localhost:3306/jdbc-ajay";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,password);
			
			stmt=con.createStatement();
			
			res=stmt.executeQuery("Select * from `employee`");
			
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
		
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
			
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
			if(res!=null)
			{
				try {
					res.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}

	}

}
