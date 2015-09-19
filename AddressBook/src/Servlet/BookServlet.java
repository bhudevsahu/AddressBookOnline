package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connections.BookDao;
import Model.BookModel;

/**
 * @author Bhudev Sahu
 */

//Servlet class, to handle all the requests coming from web-pages and sending the responses back to those pages using HttpServlet request and response

public class BookServlet extends HttpServlet
{


	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * 
	 * Called by the server (via the service method) to allow a servlet to handle a GET request.
	 */
	
	static BookModel book = new BookModel();		//Create a global BookModel object to store all the information from the page.
	HttpSession session;
	
	public static BookModel getBook() 
	{
		return book;
	}
	
	
	
	public static BookModel fetchDetails(String userId)
	{
		BookModel book = new BookDao().fetchDetails(userId);		
		return book;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String formType = request.getParameter("form");		//Get the content of the form.
		
		if(formType.equals("SignUpForm"))			//If the get request is coming from SignUp page.
		{
			//Fetch the details of the user and store them into BookModel object.
			
			book.setName(request.getParameter("name"));
			book.setUserId(request.getParameter("userId"));
			book.setPassowrd(request.getParameter("password"));
			book.setGender(request.getParameter("gender"));
			book.setPhone(request.getParameter("phone"));
			book.setAddress(request.getParameter("address"));
			book.setCity(request.getParameter("city"));
			book.setCountry(request.getParameter("country"));
			
			BookDao bookdao = new BookDao();	//Create a BookDao object to perform the DB operations.
			int status;							//Capture the sign-up status as integer.
			
			if(!book.getUserId().equals("admin"))	//If the provided user id is not "admin". 
			{
				status = bookdao.signUpUser(book);
			}
			else								//If the provided user id is "admin".
			{
				status = 1;
			}
			
			
			if(status==0)		//If the sign-up is successful.
			{
				HttpSession session = request.getSession();
				session.setAttribute("userid", book.getUserId());
				session.setAttribute("username", book.getName());
				request.setAttribute("message","success_sign_up");
				request.setAttribute("username",book.getName());
				request.setAttribute("userid",book.getUserId());
				request.getRequestDispatcher("./JSP/Message.jsp").forward(request,response);
			}
			else if(status==1)			//Duplicate user-id.
			{
				request.setAttribute("message","error_sign_up_primary");
				request.getRequestDispatcher("./JSP/Message.jsp").forward(request,response);				
				
			}
			else					//Something else.
			{
				request.setAttribute("message","error_sign_up");
				request.getRequestDispatcher("./JSP/Message.jsp").forward(request,response);				
				
			}
			
			
			
		}
		else if(formType.equals("CreateNewUserForm"))			//If the get request is coming from Create New User page.
		{
			//Fetch the details of the user and store them into BookModel object.
			
			book.setName(request.getParameter("name"));
			book.setUserId(request.getParameter("userId"));
			book.setPassowrd(request.getParameter("password"));
			book.setGender(request.getParameter("gender"));
			book.setPhone(request.getParameter("phone"));
			book.setAddress(request.getParameter("address"));
			book.setCity(request.getParameter("city"));
			book.setCountry(request.getParameter("country"));
			
			BookDao bookdao = new BookDao();	//Create a BookDao object to perform the DB operations.
			int status = bookdao.createNewUser(book);							//Capture the new user account creation status as integer.
			
			
			
			if(status==0)		//If the user account creation is successful.
			{							
				request.setAttribute("username",book.getName());
				request.setAttribute("userid",book.getUserId());
				request.setAttribute("message","success_create_user");
				request.getRequestDispatcher("./JSP/Message.jsp").forward(request,response);
			}
			else if(status==1)			//Duplicate user-id.
			{
				request.setAttribute("message","error_create_user_primary");
				request.getRequestDispatcher("./JSP/Message.jsp").forward(request,response);				
				
			}
			else					//Something else.
			{
				request.setAttribute("message","error_create_user");
				request.getRequestDispatcher("./JSP/Message.jsp").forward(request,response);				
				
			}
			
			
			
		}	
		else if(formType.equals("LoginForm"))			//If the get request is coming from Login page.
		{
			//Store user id and password from the sign-up page locally.
			String userId = request.getParameter("userid");
			String password = request.getParameter("password");
	
			
			BookDao bookdao = new BookDao();	//Create a BookDao object to perform the DB operations.
			//BookModel book = new BookModel(); 	//Create a BookModel object to hold the user details.
		
			
			if(bookdao.login(userId, password, book) || ((userId.equals("admin")) && (password.equals("admin"))))	//If the login is successful or
			{																										//it is Admin login
								
				session = request.getSession();
				
				if(userId.equals("admin"))		//If admin logs in.
				{		
					book.setUserId("admin");
					book.setName("Administrator");
					session.setAttribute("userid", "admin");
					session.setAttribute("username", "Administrator");
					request.getRequestDispatcher("./JSP/AdminHome.jsp").forward(request,response);
				}
				else			//If another user logs in.
				{
					session.setAttribute("userid", book.getUserId());
					session.setAttribute("username", book.getName());
					request.getRequestDispatcher("./JSP/UserHome.jsp").forward(request,response);
				}
				
				
				
			}
			else		//If the login is not successful.
			{				
				
				request.setAttribute("message","error_sign_in");
				request.getRequestDispatcher("./JSP/Message.jsp").forward(request,response);				
				
			}
			
		}
		
		else if(formType.equals("UpdateUserForm"))				//If the get request is coming from Update page.
		{
			//Fetch the details of the user and store them into BookModel object.
			
			book.setName(request.getParameter("name"));			
			book.setPassowrd(request.getParameter("password"));
			book.setGender(request.getParameter("gender"));
			book.setPhone(request.getParameter("phone"));
			book.setAddress(request.getParameter("address"));
			book.setCity(request.getParameter("city"));
			book.setCountry(request.getParameter("country"));
			
			BookDao bookdao = new BookDao();	//Create a BookDao object to perform the DB operations.
			
			if(bookdao.updateUser(book))			//If the update is successful.
			{
				
				request.setAttribute("message","success_update");
				request.getRequestDispatcher("./JSP/Message.jsp").forward(request,response);
			}
			else				//If the update is not successful.
			{
				request.setAttribute("message","error_update");
				request.getRequestDispatcher("./JSP/Message.jsp").forward(request,response);
			}
		}
		
		else if(formType.equals("DeleteConfirmationForm"))				//If the get request is coming from Delete confirmation page.
		{
			BookDao bookdao = new BookDao();	//Create a BookDao object to perform the DB operations.
			
			if(bookdao.deleteUser(book.getUserId()))			//If the delete is successful.
			{				
				request.setAttribute("message","success_delete");
				request.getRequestDispatcher("./JSP/Message.jsp").forward(request,response);
			}
			else				//If the delete is not successful.
			{
				request.setAttribute("message","error_delete");
				request.getRequestDispatcher("./JSP/Message.jsp").forward(request,response);
			}
		}
		
		else if(formType.equals("LocateUsersForm"))				//If the get request is coming from Locate user page.
		{
			String userId = request.getParameter("radio");		//Get the user-id from selected radio button and store it in a string.
			String operation = request.getParameter("operation");	//Get the type of operation (Update/Delete).
			//System.out.println(userId);		
			book.setUserId(userId);			//Set the user-id as the selected one.
			
			if(operation.equals("Update"))				//If the update operation is performed.
			{
				request.getRequestDispatcher("./JSP/UpdateUser.jsp").forward(request,response);
			}
			else if(operation.equals("Delete"))			//If the delete operation is performed.
			{
				request.getRequestDispatcher("./JSP/DeleteConfirm.jsp").forward(request,response);
			}
			
		}
	}
}

