package employee_master;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Employee_Service {
	
	
	public int employeeLogin(String username,String pass) throws Exception
	{
		int a=0;
		try
		{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			PreparedStatement st=con.prepareStatement("Select name,emp_pass from employee_master");
			
			ResultSet rs = st.executeQuery();
			System.out.println(username);
			System.out.println(pass);
			
			while(rs.next())
			{
				if(username.equals(rs.getString(1)) && pass.equals(rs.getString(2)))
				{
					a=1;
					break;
				}
			}
			System.out.println(a);
			return a;
		}
		
		catch(Exception ex) 
		{
			System.out.println("Exception encountered : "+ex);
		}
		
		
		
		
		return a;
		
	}

}
