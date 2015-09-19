function validate()
{
	valid = true;
	var mandate = document.getElementsByClassName("mandate");
	var i;
	
	for(i = 0;i<mandate.length;i++)
	{
		if(mandate[i].value == "")
		{
			alert("Field marked as * are mandatory fields!");
			valid = false;
			return valid;
		}
	}
	if(valid == true)
		valid = validatePassword();	
	return valid;
	
}

function validatePassword()
{
	valid = true;
	var password = document.getElementById("password");
	var cnfPassword = document.getElementById("cnfPassword");
	
	if(password.value != cnfPassword.value)
	{
		alert("Passwords in both fields do not match!");
		valid = false;
		return valid;
	}
	return valid;
}