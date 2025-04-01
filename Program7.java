
//write a program to update the salary through a particular department

package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Program7 {

		
		static Scanner scan= new Scanner(System.in);

		public static void main(String[] args) {
			
			String url="jdbc:mysql://localhost:3306/jdbc-ajay";
			String username="root";
			String password="root";
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con=DriverManager.getConnection(url, username, password);
				
				String Sql="update`employee` set `salary`=`salary`+ ? where `dept`=?";
				
				PreparedStatement pstmt=con.prepareStatement(Sql);
								
				Program2.displayEmployee(pstmt);
				
				System.out.println("Enter the increment salary :");
				
				int inc= scan.nextInt();
				
				System.out.println("Enter the department name:");
				
				String department=scan.next();
				
				
				pstmt.setInt(1, inc);
				
				pstmt.setString(2, department);
				
				int n=pstmt.executeUpdate();
				
				System.out.println(n);
				
				
			
				
				Program2.displayEmployee(pstmt);
				
				
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

	}

}
