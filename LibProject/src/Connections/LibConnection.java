package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibConnection
{
	public static Connection connectDao()
	{
		try
		{
			
			Connection dbconn= null;
			String url = "jdbc:mysql://localhost:3306/Library";
			String user="root";
			String password="tiger";

			Class.forName("com.mysql.jdbc.Driver");
			dbconn=DriverManager.getConnection(url, user, password);
			return dbconn;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return null;	
		
		
	}
	
	public static void commitChange()
	{
		try
		{
			Connection dbconn= null;
			String url = "jdbc:mysql://localhost:3306/Library";
			String user="root";
			String password="tiger";

			Class.forName("com.mysql.jdbc.Driver");
			dbconn=DriverManager.getConnection(url, user, password);
			dbconn.commit();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		
		
	}
	}

