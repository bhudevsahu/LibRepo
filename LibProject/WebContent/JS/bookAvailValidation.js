function validate()
{
	valid = true;
	var a= document.getElementById("bi");
	var a1= document.getElementById("titl");
	var a2= document.getElementById("an");
	if (a.value == "")
		if (a1.value == "")
			if (a2.value == "")
				{
					alert("Enter value on at least one field");
					valid = false;
					return valid;
				}
	return valid;
}