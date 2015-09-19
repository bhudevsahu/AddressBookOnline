package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Bhudev Sahu
 */
/*
 * Connection class with all the Database parameters to connect, perform, commit the transaction and close the connection once everything is done.
 */

public class BookConnection 
{
	
	public static Connection connectDao()		//Method which creates the connection with preset parameters.
	{
		try 
		{
			Connection dbCon = null;		//Connection object.
			String url = "jdbc:mysql://localhost:3306/AddressBook";		//Database URL.
			String user = "root";			//Database user name.
			String password = "tiger";		//Database password w.r.t. user name. 
		
		
			Class.forName("com.mysql.jdbc.Driver");	//Returns the object of the given class in the string, basically initialising com.mysql.jdbc.Driver	
			dbCon = DriverManager.getConnection(url, user, password);	//Establishes the connection with the provided DB.		
			return dbCon;		// Return the connection instance.
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void commitChange()		//Function to commit the Database changes.
	{
		try
		{
			String url = "jdbc:mysql://localhost:3306/AddressBook";
			String user = "root";
			String password = "tiger";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection dbcon = DriverManager.getConnection(url, user, password);
			dbcon.commit();
		}
		catch(SQLException e)
		{
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
}

