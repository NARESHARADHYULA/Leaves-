import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Signup_Servlet
 */
@WebServlet("/Signup_Servlet")
public class Signup_Servlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	Statement st=null;
    Connection con=null;
    ResultSet rs=null;
    public void doget(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
    	String user=request.getParameter("usermail"); 
    	String pass=request.getParameter("password"); 
    	
		con=Connectivity.getConnection();
		
		int n=0;
		try
		{
			st=con.createStatement();
			String query = "select Name , password FROM Employees WHERE  Emailid = '"+user+"' ";
			System.out.println(query);
			ResultSet rs=st.executeQuery(query);
			
				while(rs.next())
				{					
					String password = rs.getString(1);
					String name = rs.getString(2);
					PrintWriter pw=response.getWriter();
					/*String type = rs.getString(3);
					String email = rs.getString(4);
					String password = rs.getString(5);
					String designation = rs.getString(6);
					String department = rs.getString(7);
					PrintWriter pw=response.getWriter();
					pw.println("values updated");	
					pw.println("Email : "+email);
					pw.println("Password: "+password);
					pw.println("Name: "+name);
					pw.println("Id: "+id);
					pw.println("designation: "+designation);
					pw.println("department: "+department);*/
					pw.println("Name: "+name);
				}		
				rs.close();
		}
			
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
