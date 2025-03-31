
//write a program to insert all the details through user 


package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program8 {
	
	static Scanner scan= new Scanner(System.in);

	public static void main(String[] args) {

		
		
		String url="jdbc:mysql://localhost:3306/jdbc-ajay";
		String username="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			
			String sql="Insert into employee(id,name,email,dept,salary)values(?,?,?,?,?)";
			
			
			System.out.println("Enter the id :");
			int idNo=scan.nextInt();
			scan.nextLine();
			
			System.out.print("enter the name of the person:");
			String employeeName=scan.nextLine();
			
			System.out.print("enter the email of the person:");
			String employeeEmail=scan.nextLine();
			
			System.out.print("enter the department of the person:");
			String departmentName=scan.nextLine();
			
			System.out.print("enter the salary of the person:");
			int employeeSalary=scan.nextInt();
			
			PreparedStatement pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1,idNo);
			
			pstmt.setString(2, employeeName);
			
			pstmt.setString(3, employeeEmail);
			
			pstmt.setString(4, departmentName);
			
			pstmt.setInt(5, employeeSalary);
			
			int n =pstmt.executeUpdate();
			
			System.out.println(n);
			
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		

	}

}
