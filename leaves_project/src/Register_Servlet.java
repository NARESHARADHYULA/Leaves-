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
 * Servlet implementation class Register_Servlet
 */
@WebServlet("/Register_Servlet")
public class Register_Servlet extends HttpServlet {
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
			String query = "INSERT INTO register(username, password) VALUES('"+user+"','"+pass+"')";
			System.out.println(query);
			n=st.executeUpdate(query);
			if(n>0)
			{
				PrintWriter pw=response.getWriter();
				pw.println("values updated");
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
