<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Servlet.BookServlet"%>
<html>
<head>
<meta name="author" content="Bhudev Sahu"/>
<meta name="description" content="Address-Book"/>
<link rel='shortcut icon' href='/AddressBook/images/favicon.ico' type='image/x-icon'/>
<title>Processing</title>


<%--
<%String str = (String) request.getAttribute("message");
if(str.equals("error in sign in"))
{%>
<div align="center">
<h3 style="color: red;">Given user id and password does not match, try again!</h3>
<br/>
<input type="button" value="Retry" name="login"	onclick="location.href = 'JSP/LoginPage.jsp';" />

</div>
	
<% }%>
 --%>
 
 <%String str = (String) request.getAttribute("message");
if(str.equals("error_sign_in")){ %>
<script language="javascript">
	alert("Given user id and password does not match, try again!");
	window.location = "/AddressBook/JSP/LoginPage.jsp";
</script>

<%
}else if(str.equals("error_sign_up_primary"))
{%>
<script language="javascript">
	alert("User-id already in use, try again with different one!");
	window.location = "/AddressBook/JSP/Signup.jsp";
</script>
	
<%
}else if(str.equals("error_sign_up"))
{%>
<script language="javascript">
	alert("Some problem occured, try again!");
	window.location = "/AddressBook/JSP/Signup.jsp";
</script>
	
<%
}else if(str.equals("success_sign_up"))
{
	String username = (String) request.getAttribute("username");
	String userid = (String) request.getAttribute("userid");
%>
<script language="javascript">
	alert("User: <%=username%> with User ID: <%=userid%>, is successfully registered!");
	window.location = "/AddressBook/JSP/UserHome.jsp";
</script>
	
<%
}else if(str.equals("success_logout"))
{
	String username = (String) request.getAttribute("username");
%>
<script language="javascript">
<%if(username!=null){%>
	alert("<%=username%> is successfully logged out!");
	<%}%>
	window.location = "/AddressBook/JSP/LoginPage.jsp";
</script>
	
<%}
else if(str.equals("success_update"))
{%>
<script language="javascript">
	alert("User details updated successfully");	
	<%if(session.getAttribute("userid").toString().trim().equals("admin")){%>
	window.location = "/AddressBook/JSP/AdminHome.jsp";
	<%}else{%>
	window.location = "/AddressBook/JSP/UserHome.jsp";
	<%}%>
	
</script>
<%
}else if(str.equals("error_update"))
{%>
<script language="javascript">
	alert("Update could not be performed, try again!");
	<%if(session.getAttribute("userid").equals("admin")){%>
	window.location = "/AddressBook/JSP/AdminHome.jsp";
	<%}else{%>
	window.location = "/AddressBook/JSP/UserHome.jsp";
	<%}%>
</script>
<%}
else if(str.equals("success_delete"))
{%>
<script language="javascript">
	alert("User account deleted successfully");
	<%if(session.getAttribute("userid").equals("admin")){%>
	window.location = "/AddressBook/JSP/AdminHome.jsp";
	<%}else
	{
		session.invalidate();		//Terminate the session after deletion of the account.
	%>
	window.location = "/AddressBook/JSP/LoginPage.jsp";
	<%}%>
	
</script>
<%
}else if(str.equals("error_delete"))
{%>
<script language="javascript">
	alert("Deletion of the account could not be performed, try again!");
	<%if(session.getAttribute("userid").equals("admin")){%>
	window.location = "/AddressBook/JSP/AdminHome.jsp";
	<%}else{%>
	window.location = "/AddressBook/JSP/UserHome.jsp";
	<%}%>
</script>
<%
}else if(str.equals("success_create_user"))
{
	String username = (String) request.getAttribute("username");
	String userid = (String) request.getAttribute("userid");
%>
<script language="javascript">
	alert("User: <%=username%> with User ID: <%=userid%>, is successfully registered!");
	window.location = "/AddressBook/JSP/AdminHome.jsp";
</script>
	
<%
}
else if(str.equals("error_create_user_primary"))
{%>
<script language="javascript">
	alert("User-id already in use, try again with different one!");
	window.location = "/AddressBook/JSP/CreateNewUser.jsp";
</script>
	
<%
}else if(str.equals("error_create_user"))
{%>
<script language="javascript">
	alert("Some problem occured, try again!");
	window.location = "/AddressBook/JSP/CreateNewUser.jsp";
</script>
	
<%
}
%>



</body>

</html>