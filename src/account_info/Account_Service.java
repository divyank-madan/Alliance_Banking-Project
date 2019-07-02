package account_info;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import customer_master.Customer_Master_Pojo;

public class Account_Service {
	
	
	public int addAccount(String custid,String bid,String register_date,String activation_date,String account_type,String account_status,String opening_balance)
	{
		int a=0;
		try{
			int count=0;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver ());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			PreparedStatement ps=con.prepareStatement("insert into account_info values(?,?,?,?,?,?,?,?)");
			Statement pst = con.createStatement();
			ResultSet rs = pst.executeQuery("Select account_no from account_info");
			while(rs.next())
			{
				count++;
			}
			
			ps.setString(1,Integer.toString(count+1));
			ps.setString(2,custid);
			ps.setString(3, bid);
			ps.setString(4, register_date);
			ps.setString(5, activation_date);
			ps.setString(6, account_type);
			ps.setString(7, account_status);
			ps.setString(8, opening_balance);

			
			a=ps.executeUpdate();
			System.out.println("Insertion done for the row.");
			
			ps.close(); 	
			con.close();
			
		}catch(Exception ex){
			System.out.println("Exception encountered : "+ex);
		}
		return a;
	}
	
	public int deleteAccount(String id)
	{
		int a=0;
		try{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			Scanner s = new Scanner(System.in);
			DatabaseMetaData dmd=con.getMetaData();
			
			
			if(dmd.supportsANSI92EntryLevelSQL()){
				PreparedStatement ps=con.prepareStatement("delete from account_info where custid=?");
				ps.setString(1, id);
				
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
	
	public Customer_Master_Pojo viewAccount(String searchid)
	{
		Customer_Master_Pojo ob = new Customer_Master_Pojo();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			PreparedStatement st=con.prepareStatement
			("Select cm.custid,cm.fname,cm.lname,cm.gender,cm.dob,cm.address,cm.mobileno,cm.emailid from  customer_master cm inner join account_info ai ON (ai.custid=cm.custid) where ai.custid=?");
			st.setString(1,searchid);
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				ob.setCustid(rs.getString(1));
				ob.setFname(rs.getString(2));
				ob.setLname(rs.getString(3));
				ob.setGender(rs.getString(4));
				ob.setDob(rs.getString(5));
				ob.setAddress(rs.getString(6));
				ob.setMobileno(rs.getString(7));
				ob.setEmailid(rs.getString(8));
			}
			rs.close();
			st.close(); 	
			con.close();
			
			return ob;
		}
		catch(Exception ex)
		{
			System.out.println("Exception encountered : "+ex);
		}
		
		return ob;
	}

	public int updateAccount(String accountid,String val1,String val2,String val3,String val4,String val5)
	{ 
		int a=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			PreparedStatement ps=con.prepareStatement
			("update account_info set custid=?,branch_id=?,"
					+ "account_type=?,account_status=?,opening_balance=? where account_no=?");
			
			ps.setString(1, val1);
			ps.setString(2, val2);
			ps.setString(3, val3);
			ps.setString(4, val4);
			ps.setInt(5, Integer.parseInt(val5));
			ps.setString(6, accountid);
			
			a=ps.executeUpdate();

			ps.close();
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println("Exception encountered : "+ex);
		}
		
		
		return a;
	}
		
		
		
		
		
	}

	


