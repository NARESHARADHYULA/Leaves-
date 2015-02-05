import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection; 

public class Connectivity
{
	static Connection con;
	public static Connection getConnection()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");
			System.out.println("con======"+con);
			System.out.println("Connection established");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
public static void main(String[] args)
{
	Connectivity.getConnection();
	}
}
