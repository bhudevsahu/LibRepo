function validate()
{
	valid = true;
	var a1= document.getElementById("cn");
	var a2= document.getElementById("bn");
	if (a1.value == "")
		if (a2.value == "")
			{
				alert("Enter value on at least one field");
				valid = false;
				return valid;
			}
	return valid;
}