
//write a program to fetch all the details of the employee table where the department is particular department

package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Program6 {
	
	static Scanner scan= new Scanner(System.in);

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/jdbc-ajay";
		String username="root";
		String password="root";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url, username, password);
			
			String Sql="Select * from `employee` where `dept`=?";
			
			System.out.println("Enter the department name:");
			
			String department=scan.next();
			
			PreparedStatement pstmt=con.prepareStatement(Sql);
			
			pstmt.setString(1, department);
			
			ResultSet res=pstmt.executeQuery();
			
			
			System.out.println("------------------------------------------------------");
			
			while(res.next())
			{
				int id=res.getInt("id");
				String name=res.getString("Name");
				String email=res.getString("email");
				String dept=res.getString("dept");
				int salary=res.getInt("salary");
				
				System.out.printf("|%-3d|%-10s|%-20s|%-10s|%-7d|\n",id,name,email,dept,salary);
			}
			
			System.out.println("-------------------------------------------------------");
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
