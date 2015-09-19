package Connections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import Model.BookModel;

/**
 * @author Bhudev Sahu
 */
/*
 * DAO class to perform all the Database operation. It initialises the connection, perform the operation and returns the required output.
 */
public class BookDao 
{
	
	public int signUpUser(BookModel book)		//DB operation for sign-up
	{
		Connection connection = BookConnection.connectDao();	//Create a connection with MySQL to perform DB operations.
		try
		{
			Statement statement = connection.createStatement();		//Creates a Statement object for sending SQL statements to the database.
			
			// Query to insert user details into Usertable.
			String query = "INSERT INTO Usertable VALUES('"+book.getName()+"', '"+book.getUserId()+"', '"+book.getPassowrd()+"', '"+book.getGender()+"', '"+book.getPhone()+"', '"+book.getAddress()+"', '"+book.getCity()+"', '"+book.getCountry()+"')";
			//System.out.println(query);				//Print the query on console. 
			statement.executeUpdate(query);			//Execute the insert query.
		}
		catch(SQLException e)
		{	
			if(e.getMessage().contains("'PRIMARY'"))
			{
				return 1;
			}
			else
			{
				return 2;
			}
		}
		return 0;
	}
	
	public int createNewUser(BookModel book)		//DB operation for creating new user
	{
		Connection connection = BookConnection.connectDao();	//Create a connection with MySQL to perform DB operations.
		try
		{
			Statement statement = connection.createStatement();		//Creates a Statement object for sending SQL statements to the database.
			
			// Query to insert user details into Usertable.
			String query = "INSERT INTO Usertable VALUES('"+book.getName()+"', '"+book.getUserId()+"', '"+book.getPassowrd()+"', '"+book.getGender()+"', '"+book.getPhone()+"', '"+book.getAddress()+"', '"+book.getCity()+"', '"+book.getCountry()+"')";
			//System.out.println(query);				//Print the query on console. 
			statement.executeUpdate(query);			//Execute the insert query.
		}
		catch(SQLException e)
		{	
			if(e.getMessage().contains("'PRIMARY'"))
			{
				return 1;
			}
			else
			{
				return 2;
			}
		}
		return 0;
	}
	
	public boolean login(String userId, String password, BookModel book)	//DB operation for login
	{			
		Connection connection = BookConnection.connectDao();	//Create a connection with MySQL to perform DB operations.
		ResultSet resultset;
		try
		{
			Statement statement = connection.createStatement();		//Creates a Statement object for sending SQL statements to the database.
			
			//Query to check login credentials.
			String query = "SELECT passwd FROM Usertable where userid = '"+userId+"'"; 			
			resultset = statement.executeQuery(query);		//Collect the result in the result-set object.
			
			if(resultset.next())
			{
				String passwd = resultset.getString(1);		//Store the password in the DB locally.
				
				if(passwd.trim().equals(password))
				{
					query = "SELECT * FROM Usertable where userid = '"+userId+"'";	//Now get all other details for the particular user. 			
					resultset = statement.executeQuery(query);		//Collect the result in the result-set object.
					if(resultset.next())
					{
						//Store all the information in BookModel object.
						book.setName(resultset.getString(1));
						book.setUserId(resultset.getString(2));
						book.setGender(resultset.getString(4));
						book.setPhone(resultset.getString(5));
						book.setAddress(resultset.getString(6));
						book.setCity(resultset.getString(7));
						book.setCountry(resultset.getString(8));
					}
					
					return true;
				}
			}
		
			
		}
		catch(SQLException e)
		{			
			e.printStackTrace();			
		}
		return false;
		
	}
	
	public boolean updateUser(BookModel book)		//DB operation for update user info.
	{
		Connection connection = BookConnection.connectDao();	//Create a connection with MySQL to perform DB operations.
		try
		{
			Statement statement = connection.createStatement();		//Creates a Statement object for sending SQL statements to the database.
			
			// Query to update user details into Usertable.
			String query = "UPDATE Usertable SET UName = '"+book.getName()+"', Gender= '"+book.getGender()+"', Phone= '"+book.getPhone()+"', Address= '"+book.getAddress()+"', City= '"+book.getCity()+"', Country= '"+book.getCountry()+"' WHERE UserId= '"+book.getUserId()+"'";
			//System.out.println(query);				//Print the query on console. 
			statement.executeUpdate(query);			//Execute the update query.
		}
		catch(SQLException e)
		{	
			return false;
		}
		return true;
	}
	
	public BookModel fetchDetails(String userId)		//DB operation for fetching all the user info.
	{
		BookModel book = new BookModel();			
		
		Connection connection = BookConnection.connectDao();	//Create a connection with MySQL to perform DB operations.
		ResultSet resultset;
		try
		{
			Statement statement = connection.createStatement();		//Creates a Statement object for sending SQL statements to the database.
			String query = "SELECT * FROM Usertable where userid = '"+userId+"'";	//Now get all details for the particular user. 			
			resultset = statement.executeQuery(query);		//Collect the result in the result-set object.
			if(resultset.next())
			{
				//Store all the information in BookModel object.
				book.setName(resultset.getString(1));
				book.setUserId(resultset.getString(2));
				book.setGender(resultset.getString(4));
				book.setPhone(resultset.getString(5));
				book.setAddress(resultset.getString(6));
				book.setCity(resultset.getString(7));
				book.setCountry(resultset.getString(8));
			}
		}
		catch(SQLException e)
		{			
			e.printStackTrace();			
		}

		return book;
	}

	public boolean deleteUser(String userId)		//DB operation for deleting a user profile.
	{
		Connection connection = BookConnection.connectDao();	//Create a connection with MySQL to perform DB operations.
		try
		{
			Statement statement = connection.createStatement();		//Creates a Statement object for sending SQL statements to the database.
			
			// Query to delete user details from Usertable.
			String query = "DELETE FROM Usertable WHERE UserId ='"+userId+"'";
			//System.out.println(query);				//Print the query on console. 
			statement.executeUpdate(query);			//Execute the insert query.
		}
		catch(SQLException e)
		{	
			return false;
		}
		return true;		
	}
	
	public String performAjax(String keyword)		//DB operation for fetching all the user info using AJAX.
	{
		String output="<users>";		//Initialise a string which will be an xml output.
		Connection connection = BookConnection.connectDao();	//Create a connection with MySQL to perform DB operations.
		ResultSet resultset;
		try
		{
			Statement statement = connection.createStatement();		//Creates a Statement object for sending SQL statements to the database.
			
			// Query to delete user details from Usertable.
			String query = "SELECT * FROM Usertable WHERE Userid LIKE '%"+keyword+"%' OR UName LIKE '%"+keyword+"%' OR Gender LIKE '%"+keyword+"%' OR Phone LIKE '%"+keyword+"%' OR Address LIKE '%"+keyword+"%' OR City LIKE '%"+keyword+"%' OR Country LIKE '%"+keyword+"%'";
			//System.out.println(query);				//Print the query on console. 
			resultset = statement.executeQuery(query);		//Collect the result in the result-set object.
			if(resultset.next())
			{
				do
				{
					//output+="<user id=\""+resultset.getString(2)+"\">";
					output+="<user>";
					output+="<name>"+resultset.getString(1)+"</name>";
					output+="<userid>"+resultset.getString(2)+"</userid>";
					output+="<gender>"+resultset.getString(4)+"</gender>";
					output+="<phone>"+resultset.getString(5)+"</phone>";
					output+="<fulladdress>"+resultset.getString(6)+", "+resultset.getString(7)+", "+resultset.getString(8)+"</fulladdress>";
					output+="</user>";
				}
				while(resultset.next());
			}
			output+="</users>";
		}
		catch(SQLException e)
		{	
			
		}
		
		return output;
	}
		
}

