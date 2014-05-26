function validate()
{
	valid = true;
	var a= document.getElementById("cn");
	if (a.value == "")
	{
		alert("Enter card number");
		valid = false;
		return valid;
	}
	else
	{
		var a1=a.value;
		if(a1.length < 4)
		{
			alert("Enter the full 4 digit card number");
			valid = false;
			return valid;
		}
	}

	return valid;

}