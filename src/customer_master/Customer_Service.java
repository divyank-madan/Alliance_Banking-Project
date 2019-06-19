package customer_master;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Customer_Service {
	
	static int id=1;
	public int insertCustomer(String fname,String lname,String gender,String dob,String address,String mobileno,String emailid,String password)
	{
		int a=0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver ());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			PreparedStatement ps=con.prepareStatement("insert into customer_master values(?,?,?,?,?,?,?,?,?)");
		
			ps.setString(1,Integer.toString(id));
			id++;
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, gender);
			ps.setString(5, dob);
			ps.setString(6, address);
			ps.setString(7, mobileno);
			ps.setString(8, emailid);
			ps.setString(9, password);
			
			a=ps.executeUpdate();
			System.out.println("Insertion done for the row.");
			
			ps.close(); 	
			con.close();
			
		}catch(Exception ex){
			System.out.println("Exception encountered : "+ex);
		}
		return a;
	}
	
	public int deleteCustomer(int id)
	{
		int a=0;
		try{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			Scanner s = new Scanner(System.in);
			DatabaseMetaData dmd=con.getMetaData();
			
			
			if(dmd.supportsANSI92EntryLevelSQL()){
				PreparedStatement ps=con.prepareStatement("delete from customer_master where custid=?");
				ps.setInt(1, id);
				
				int r = ps.executeUpdate();
				System.out.println("Deletion done for the row."+r);
				ps.close(); 
			}else{
				System.out.println("ANSI-92 SQL not supported !!!");
			}

			con.close();
			
		}catch(Exception ex){
			System.out.println("Exception encountered : "+ex);
		}
		
		return a;

	}

	}


