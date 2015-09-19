package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Bhudev Sahu
 */

/*
 * Servlet class to handle logout requests.
 */
public class BookLogoutServlet extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 HttpSession session=request.getSession();		//Get the session in session variable.
		 String username = (String)session.getAttribute("username");	//Get the user-name out of session.		 
         session.invalidate(); 			//Terminate the session for the current user.
         request.setAttribute("username",username);		//Set these parameters for displaying purpose.
         request.setAttribute("message","success_logout");
         request.getRequestDispatcher("./JSP/Message.jsp").forward(request,response);		
	}
	
}

