<%@page import="com.sun.webkit.ContextMenu.ShowContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="author" content="Bhudev Sahu"/>
<meta name="description" content="Address-Book"/>
<link rel='shortcut icon' href='/AddressBook/images/favicon.ico' type='image/x-icon'/>
<title>Login Page</title>

<script type="text/javascript" src="/AddressBook/JavaScripts/login.js"></script>


</head>
<body background="/AddressBook/images/back-ground.jpg" >
<table>
                <tr>
                    <td width="5%" height="100px">               
                    </td>
                    <td width="95%">
                       
                            <div style="font-family:Verdana;font-weight:bold; 

font-size:x-large; color: #5C1919; " align="center" >
                                <i>Address Book</i>

                            </div>
                      
                        <br/>
                            </td>
                </tr>                      
                        
                
            </table>
            <hr />

<form action="/AddressBook/BookServlet" method="get" >
<input type="text" name="form" value="LoginForm" style="visibility: hidden" />

<table border="0" cellpadding="4" align="center">
	<tr>
		<td colspan="3">
		<h2 align="center">&nbsp;&nbsp; &nbsp;&nbsp; Login</h2>

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
		<td>User ID:<span class="mandat"><font size="3" color="red">
		*</font></span>:</td>

		<td><input type="text" title="Enter User ID" id="userid" 

name="userid"
			size="20" maxlength="30" /></td>
	</tr>
	<tr>	
		<td>Password<span class="mandat"><font size="3" color="red">
		*</font></span>:</td>

		<td><input type="password" title="Enter Password" id="password" name="password"	size="20" maxlength="20" /></td>
	</tr>
	
	<tr></tr>
	<tr></tr>
	<tr></tr>
	
</table>
<div align="center">
	<input type="submit" value="Login" name="login"
			onclick="return validate()" />
		<input type="button" value="Sign-up" name="signup"
			onclick="location.href = 'Signup.jsp';" /> 
	</div>
</form>
    

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

	
<%--
<% String message = (String)request.getAttribute("message");%>
<% if(message.equals("error")){ %>
<script language="javascript">
function showError()
{
	alert("Given user id and password does not match, try again!");	
}
</script>
<%} %> --%> 
</body>

</html>