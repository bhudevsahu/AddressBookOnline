<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Servlet.BookServlet"%>
<html>
<head>

<meta name="author" content="Bhudev Sahu"/>
<meta name="description" content="Address-Book"/>
<title>Admin Home Page</title>

<link rel='shortcut icon' href='/AddressBook/images/favicon.ico' type='image/x-icon'/>


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
<%if(session.getAttribute("userid").equals("admin")){ %>            
<a href="/AddressBook/JSP/AdminHome.jsp" style="text-decoration: none;color: black;">&nbsp;&nbsp;
&nbsp;&nbsp;Home</a>
<%} 
else
{%>
<a href="/AddressBook/JSP/LoginPage.jsp" style="text-decoration: none;color: black;">&nbsp;&nbsp;
&nbsp;&nbsp;Home</a>
<%} %>

<div style="font-family:monospace; font-weight:lighter ; font-size:large; color:richness: ; " align="right" >
<%if(session.getAttribute("userid").equals("admin")){ %>
Active User: <% out.println(session.getAttribute("username"));%><br/>
<a href="/AddressBook/BookLogoutServlet">Log-out</a>  
<%} 
else if(session.getAttribute("userid")!=null)
{%>
Active User: <% out.println(session.getAttribute("username"));%> (Unauthorized)<br/>
<a href="/AddressBook/BookLogoutServlet">Log-out</a>	
<%}
else
{%>
No active user
<%}%>
</div>
<%if(session.getAttribute("userid").equals("admin")){ %>
<table border="0" cellpadding="4" align="center">
	<tr>
		<td colspan="3">
		<h1 align="center">&nbsp;&nbsp; Admin Home Page</h1>

		</td>
	</tr>
	</table>
<div style="text-align:center">  	
<a href="/AddressBook/JSP/CreateNewUser.jsp"  style="text-decoration: none;color: black;">&nbsp;&nbsp;
&nbsp;&nbsp;1. Create New User</a>
<p></p>
<a href="/AddressBook/JSP/LocateUsers.jsp"  style="text-decoration: none; color: black;">&nbsp;&nbsp;
&nbsp;&nbsp;2. Search users</a>


</div>
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

<%} %>

</body>

</html>