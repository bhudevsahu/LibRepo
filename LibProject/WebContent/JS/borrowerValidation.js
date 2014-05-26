function validate()
{
	valid = true;
	var a1= document.getElementById("fn");
	if (a1.value == "")
	{
		alert("Enter first name");
		valid = false;
		return valid;
	}
	if(valid == true)
		valid = validate_last();
	return valid;

}

function validate_last()
{
	valid = true;
	var a2= document.getElementById("ln");
	if (a2.value == "")
	{
		alert("Enter last name");
		valid = false;	
		return valid;
	}
	else
	{
		var a=a2.value;
		if(a.length < 3)
		{
			alert("Enter atleast 3 characters of last name");
			valid = false;
			return valid;
		}
	}
	if(valid == true)
		valid = validate_addr();
	return valid;

}

function validate_addr()
{
	valid = true;
	var a3= document.getElementById("add");
	if (a3.value == "")
	{
		alert("Enter address");
		valid = false;	
		return valid;
	}
	else
	{
		var a=a3.value;
		if(a.length < 5)
		{
			alert("At least 5 characters of address should be entered ");
			valid = false;
			return valid;
		}
	}
	if(valid == true)
		valid = validate_card();
	return valid;
}

function validate_card()
{
	valid = true;
	var a2= document.getElementById("cn");
	if (a2.value == "")
	{
		alert("Enter Card No.");
		valid = false;	
		return valid;
	}
	else
	{
		var a=a2.value;
		if(a.length < 4)
		{
			alert("Card number should be of 4 digits");
			valid = false;
			return valid;
		}
	}

	return valid;

}