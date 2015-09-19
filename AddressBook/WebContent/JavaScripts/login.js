function validate()
{
	valid = true;
	var userid = document.getElementById("userid");
	var password = document.getElementById("password");
	
	if(userid.value == "")
	{
		alert("Enter User ID");
		valid = false;
		return valid;
	}
	else if(password.value == "")
	{
		alert("Enter Password");
		valid = false;
		return valid;
	}
	
	return valid;
}