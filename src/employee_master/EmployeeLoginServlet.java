package employee_master;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeLoginServlet()
    {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try(PrintWriter a=response.getWriter())
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
	
			Employee_Service es = new Employee_Service();
			int res=es.employeeLogin(username, password);
			if(res==1)
			{
				response.sendRedirect("dashboard.html");
			}
			else
			{
				response.sendRedirect("mainpage.html");
				a.println("<h1 style='color:red'>Some error in login employee occurred, check the console !!!</h1>");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Exception encountered : "+ex);
		}
	
	
	}

}
