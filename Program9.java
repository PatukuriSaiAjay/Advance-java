package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program9 {
	
	public static void main(String[] args)
	{
		
		String url="jdbc:mysql://localhost:3306/jdbc-ajay";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url, username, password);
			
			Scanner scan= new Scanner(System.in);
			
			String choice=null;
						
			String sql="Insert into `employee`(`id`,`name`,`email`,`dept`,`salary`) values (?,?,?,?,?)";
			
			PreparedStatement pstmt=con.prepareStatement(sql);
			
			Program2.displayEmployee(pstmt);
			do
			{
				
				
				System.out.println("Enter the id :");
				int idNo=scan.nextInt();			
				
				System.out.print("enter the name of the person:");
				String employeeName=scan.next();
				
				System.out.print("enter the email of the person:");
				String employeeEmail=scan.next();
				
				System.out.print("enter the department of the person:");
				String departmentName=scan.next();
				
				System.out.print("enter the salary of the person:");
				int employeeSalary=scan.nextInt();
				
				
				pstmt.setInt(1,idNo);
				
				pstmt.setString(2, employeeName);
				
				pstmt.setString(3, employeeEmail);
				
				pstmt.setString(4, departmentName);
				
				pstmt.setInt(5, employeeSalary);
				
				
				pstmt.addBatch();
				
				
				System.out.println("DO YOU WANT TO INSERT THE MORE EMPLOYEE DETAILS?(YES/NO)");
				choice=scan.next();
			}while(choice.equalsIgnoreCase("Yes"));
			
			
			int[] res=pstmt.executeBatch();
			
			for(int i:res)
			{
				System.out.print(i+" ");
			}
			

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
