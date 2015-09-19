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
	return valid;
	
}