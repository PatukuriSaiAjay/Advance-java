
//write a program to fetch all the details of the employee table 

package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {

	public static void main(String[] args) {
		
		Statement stmt= null; 
		
		Connection con= null;
		
		ResultSet res= null;
		
		
		String url="jdbc:mysql://localhost:3306/jdbc-ajay";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,password);
			
			stmt=con.createStatement();
			
		
		res = displayEmployee(stmt);
		
		
		
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		finally
		{
			myCloseMethod(stmt, con, res);
		}

	}

	public static ResultSet displayEmployee(Statement stmt) throws SQLException {
		
		ResultSet res;
		res=stmt.executeQuery("Select * from `employee`");
		
		
		System.out.println("------------------------------------------------------");
		
		while(res.next())
		{
			int id=res.getInt("id");
			String name=res.getString("Name");
			String email=res.getString("email");
			String dept=res.getString("dept");
			int salary=res.getInt("salary");
			
			System.out.printf("|%-6d|%-15s|%-20s|%-15s|%-10d|\n",id,name,email,dept,salary);
		}
		
		System.out.println("-------------------------------------------------------");
		return res;
	}

	private static void myCloseMethod(Statement stmt, Connection con, ResultSet res) {
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
