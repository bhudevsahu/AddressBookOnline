package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connections.BookDao;

/**
 * @author Bhudev Sahu
 */
/*
 * Servlet class to handle the AJAX request and send the asynchronous XML response.
 */

public class BookAjaxServlet extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
		String keyword = request.getParameter("name");	//Get the keyword to fetch records from database.
		//System.out.println(keyword);
		BookDao bookdao = new BookDao();	//Create a BookDao object to perform the DB operations.
		
		String output = bookdao.performAjax(keyword);	//Perform the DB operation and append the results in XML format.
		
		response.setContentType("text/xml");		//Set the output type to be XML.
		response.getWriter().write(output);			//Write the output on response.
		//System.out.println(output);				//Print the output in console.
	}


}

