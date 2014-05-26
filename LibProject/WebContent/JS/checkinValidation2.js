function validate()
{
	valid = true;
	var a= document.getElementById("ind");
	if (a.value == "")
	{
		alert("Enter index value");
		valid = false;
		return valid;
	}
	return valid;
}