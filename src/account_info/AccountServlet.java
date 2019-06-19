package account_info;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import customer_master.Customer_Service;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AccountServlet() {
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String dob=request.getParameter("dob");
		String address=request.getParameter("address");
		String mobileno=request.getParameter("mobile no");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String password=request.getParameter("psw");
		
		String bid=request.getParameter("bid");
		String register_date=request.getParameter("register_date");
		String activation_date=request.getParameter("activation_date");
		String account_type=request.getParameter("account_type");
		String account_status=request.getParameter("account_status");
		String opening_balance=request.getParameter("opening_balance");		
		
		String accountid = request.getParameter("accountid");
		
		response.setContentType("text/html");
		try(PrintWriter a=response.getWriter())
		{	
				Customer_Service cm = new Customer_Service();
				int res1=cm.insertCustomer(fname,lname,gender,dob,address,mobileno,email,password);
				
				Account_Service as = new Account_Service();
				int res=as.addAccount(bid,register_date,activation_date,account_type,account_status,opening_balance);
				
				if(res>0 && res1>0)
				{
				//a.println("<h1 style='color:red'>"+res+" rows successfully inserted !!!</h1>");
					response.sendRedirect("dashboard.html");	
				}
				else
				{
					a.println("<h1 style='color:red'>Some error in add account occurred, check the console !!!</h1>");
				}
				
				Account_Service as1 = new Account_Service();
				int res2=as1.deleteAccount(accountid);
				if(res2>0)
				{
					response.sendRedirect("dashboard.html");
				}
				else 
				{
					a.println("<h1 style='color:red'>Some error in delete account occurred, check the console !!!</h1>");
				}
				
		}
		catch(Exception ex)
		{
			System.out.println("Exception encountered : "+ex);
		}
	}

}
