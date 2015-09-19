function ajaxRequest(str)
{	
	
	 if (str.length == 0) 
	 	{
	        document.getElementById('myDiv').innerHTML = "";
	        return;
	    }
	 else
		 {
	
			var xmlhttp;
			if (window.XMLHttpRequest)
			{
				xmlhttp=new XMLHttpRequest();
			}
			xmlhttp.onreadystatechange=function()
			  {
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {
				  var xmlDoc=xmlhttp.responseXML;
				  var i;
				  var output = "<table border=\"1\" cellpadding=\"7\"  style=\"border-collapse:collapse;\"><tr><th>Name</th><th>User ID</th><th>Gender</th><th>Phone</th><th>Full Address</th></tr>";
				  var x=xmlDoc.getElementsByTagName("user");
				  for (i=0;i<x.length;i++)
					  {
					  	output+="<tr><td>";			  				  				  
					  	output+=x[i].getElementsByTagName("name")[0].childNodes[0].nodeValue;			  	
					  	output+="</td><td>";			  	
					  	output+=x[i].getElementsByTagName("userid")[0].childNodes[0].nodeValue;
					  	output+="</td><td>";
					  	output+=x[i].getElementsByTagName("gender")[0].childNodes[0].nodeValue;
					  	output+="</td><td>";
					  	output+=x[i].getElementsByTagName("phone")[0].childNodes[0].nodeValue;
					  	output+="</td><td>";
					  	output+=x[i].getElementsByTagName("fulladdress")[0].childNodes[0].nodeValue;
					  	output+="</td><td>";			  			  	
					  	output+="<input type=\"radio\" value=\""+x[i].getElementsByTagName("userid")[0].childNodes[0].nodeValue+"\" name=\"radio\"/>";
					  	output+="</td></tr>";
					  }
					  output+="</table>";			  
					
					  document.getElementById('myDiv').innerHTML = output;
			    }
			   };
		 }
	 
	xmlhttp.open("GET","/AddressBook/BookAjaxServlet?name="+document.getElementById('keyword').value,true);	  //?name= : sets the parameter for the
	xmlhttp.send();																							// request.
};

function validate()
{		
	var valid = false;
	var selection = document.getElementsByName("radio");	
	for (var i = 0, length = selection.length; i < length; i++)
	{	    
		if(selection[i].checked)
		{
			valid = true;
			return valid;
		}		
	}
	alert("Make a selection!");
	return valid;
}