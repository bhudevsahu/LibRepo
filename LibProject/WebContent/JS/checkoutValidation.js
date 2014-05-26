function validate()
{
	valid = true;
	var a1= document.getElementById("bi");
	if (a1.value == "")
	{
		alert("Enter Book ID");
		valid = false;
		return valid;
	}
	else
	{
		var a=a1.value;
		if(a.length < 8)
		{
			alert("No Book ID is less than 8 characters");
			valid = false;
			return valid;
		}
	}
	if(valid == true)
		valid = validate_branch();
	return valid;

}
function validate_branch()
{
	valid = true;
	var a1= document.getElementById("brid");
	if (a1.value == "")
	{
		alert("Enter Branch ID");
		valid = false;
		return valid;
	}
	else
	{
		var a= a1.value;

		for(var i=0;i<a.length;i++)
		{
			var temp ="";
			temp=a.charAt(i).match(/[0-9]/);
			if(temp==null)
			{		
				alert("Branch ID can have digit only");
				valid = false;
				return valid;
			}
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
			alert("Enter the full 4 digit card number");
			valid = false;
			return valid;
		}
	}

	return valid;

}