package account_info;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Account_Service {
	
	static int id=1;
	public int addAccount(String bid,String register_date,String activation_date,String account_type,String account_status,String opening_balance)
	{
		int a=0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver ());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			PreparedStatement ps=con.prepareStatement("insert into account_info values(?,?,?,?,?,?,?)");
		
			ps.setString(1,Integer.toString(id));
			id++;
			ps.setString(2, bid);
			ps.setString(3, register_date);
			ps.setString(4, activation_date);
			ps.setString(5, account_type);
			ps.setString(6, account_status);
			ps.setString(7, opening_balance);

			
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

	}


