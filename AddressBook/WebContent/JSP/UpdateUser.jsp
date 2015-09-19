<%@page import="Model.BookModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">


<%@page import="Servlet.BookServlet"%>
<html>
<head>
<link rel='shortcut icon' href='/AddressBook/images/favicon.ico' type='image/x-icon'/>
<meta name="author" content="Bhudev Sahu"/>
<meta name="description" content="Address-Book"/>
<title>Update User</title>

<script type="text/javascript" src="/AddressBook/JavaScripts/update.js"></script>

</head>
<body background="/AddressBook/images/back-ground.jpg">
<table>
                <tr>
                    <td width="5%" height="100px">               
                    </td>
                    <td width="95%">
                       
                            <div style="font-family:Verdana;font-weight:bold; 

font-size:x-large; color:#5C1919; " align="center" >
                                <i>Address Book</i>
                                 

                            </div>
                      
                        <br/>
                            </td>
                </tr>                      
                        
                
            </table>
            <hr />
<%if(session.getAttribute("userid")!=null)
{
	if(session.getAttribute("userid").equals("admin"))
	{
	%>            
<a href="/AddressBook/JSP/AdminHome.jsp" style="text-decoration: none;color: black;">&nbsp;&nbsp;
&nbsp;&nbsp;Home</a>
<%}else
	{%>
	<a href="/AddressBook/JSP/UserHome.jsp" style="text-decoration: none;color: black;">&nbsp;&nbsp;
&nbsp;&nbsp;Home</a>
<%} %>
<%} 
else
{%>
<a href="/AddressBook/JSP/LoginPage.jsp" style="text-decoration: none;color: black;">&nbsp;&nbsp;
&nbsp;&nbsp;Home</a>
<%} %>

<div style="font-family:monospace; font-weight:lighter ; font-size:large; color:richness: ; " align="right" >
<%if(session.getAttribute("userid")!=null){ %>
Active User: <% out.println(session.getAttribute("username"));%><br/>
<a href="/AddressBook/BookLogoutServlet">Log-out</a>  
<%} 
else
{%>
No active user
<%}%>
</div>

<%if(session.getAttribute("userid")!=null){ %>
<form action="/AddressBook/BookServlet" method="get" >
<input type="text" name="form" value="UpdateUserForm" style="visibility: hidden" />
<%BookModel book = BookServlet.fetchDetails(BookServlet.getBook().getUserId()); %>
<table border="0" cellpadding="4" align="center">
	<tr>
		<td colspan="3">
		<h2 align="center">&nbsp;&nbsp; &nbsp;&nbsp; Update User</h2>

		</td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td colspan="3">
		</td>
	</tr>
	<tr>
		<td>User Id:</td>

		<td> <%out.println(book.getUserId());%></td>
	</tr>
	<tr>
		<td>Name<span class="mandat"><font size="3" color="red">
		*</font></span>:</td>

		<td><input type="text" title="Enter Name" id="name" class="mandate"

name="name"	size="20" maxlength="20" value="<%out.println(book.getName());%>"/></td>
	</tr>
		<tr>
		<td>Gender:</td>
		<td><%if(book.getGender().equals("Male")){ %><input type="radio" name="gender" value="Male" checked>Male
		<input type="radio" name="gender" value="Female">Female
		<%}else
			{%>
			<input type="radio" name="gender" value="Male" >Male
		<input type="radio" name="gender" value="Female" checked>Female
		<%} %>
		</td><td></td>
	</tr>
	<tr>
		<td> Phone:<font size="3"></font></span></td>
		<td><input type="text" title="Enter Phone Number" id="pn"
			value="<%out.println(book.getPhone());%>" name="phone" size="13" maxlength="10" /></td>
		<td></td>
	</tr>
	
	<tr>
		<td>Address:<span class="mandat"><font size="3"
			color="red">*</font></span></td>
		<td><input type="text" class="mandate" title="Enter Address" id="address" value="<%out.println(book.getAddress());%>" name="address" size="20" maxlength="20" /></td>
	</tr>
	<tr>
		<td>City:<span class="mandat"><font size="3"
			color="red">*</font></span></td>
		<td><input type="text" title="Enter City" id="city" class="mandate"
			value="<%out.println(book.getCity());%>" name="city" size="15" maxlength="20" /></td>
	</tr>
	<tr>
		<td>Country:<span class="mandat"><font size="3"
			color="red">*</font></span></td>
		<td><input type="text" title="Enter Country" id="country" class="mandate"
			value="<%out.println(book.getCountry());%>" name="country" size="15" maxlength="20" /></td>
	</tr>		
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr>
			<td align="right"><input type="submit" value="Update"
			onclick="return validate()" /></td>
		<td><input type="reset" value="Reset" /> &nbsp;&nbsp;
		<%if(session.getAttribute("userid").equals("admin")){ %>
<input type="button" value="Cancel" onclick="window.location.href='/AddressBook/JSP/AdminHome.jsp'" />
<%}
else
{%>
<input type="button" value="Cancel" onclick="window.location.href='/AddressBook/JSP/UserHome.jsp'" />
<%} %>
	</tr>
</table>
</form>

<%} %>


  <div  id="footer" align="center" style ="position: fixed; bottom: 0; width: 100%; color: #5C1919;" >
    © All Rights Reserved :D<br/>
     <a href="https://www.facebook.com/bhudev10" target="_blank">
	<img id= "facebook" src="/AddressBook/images/facebook.png" style="border:0px solid black;max-width:3%;" alt="Facebook">
	</a>   
    <a href="https://github.com/bhudevsahu" target="_blank">
	<img id="github" src="/AddressBook/images/github.png" style="border:0px solid black;max-width:3%;" alt="Github">
	</a>
	 <a href="https://www.linkedin.com/pub/bhudev-sahu/7a/b5b/7a2" target="_blank">
	<img id="linkedin" src="/AddressBook/images/linkedin.png" style="border:0px solid black;max-width:3%;" alt="LinkedIn">
	</a> 
	<a href="https://www.youtube.com/channel/UCtVDa4pTCnKrNxx8U3-X4yg" target="_blank">
	<img id="youtube" src="/AddressBook/images/youtube.png" style="border:0px solid black;max-width:3%;" alt="Youtube">
	</a> 	
    </div>
</body>

</html>