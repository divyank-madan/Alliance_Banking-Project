package customer_master;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
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
		String confirmpass=request.getParameter("confirm_pass");
		
		
		response.setContentType("text/html");
		try(PrintWriter a=response.getWriter())
		{	
			
			if(password.equals(confirmpass) && mobileno.length()==10)
			{	
				Customer_Service cm = new Customer_Service();
				int res=cm.insertCustomer(fname,lname,gender,dob,address,mobileno,email,password);
				if(res>0)
				//a.println("<h1 style='color:red'>"+res+" rows successfully inserted !!!</h1>");
				response.sendRedirect("mainpage.html");	
				else
				a.println("<h1 style='color:red'>Some error occurred, check the console !!!</h1>");
			}
			else
			{
				a.println("<h1 style='color:red'>Password doesn't match , Try again !!</h1>");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Exception encountered : "+ex);
		}
	}

}
