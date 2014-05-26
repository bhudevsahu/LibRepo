<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="author" content="Bhudev Sahu"/>
<meta name="description" content="Library Management System"/>
<title>Check Borrower-Book Details</title>

<script type="text/javascript" src="../JS/borrowerDetailsValidation.js"></script>


</head>
<body background="../images/back-ground.jpg" >
<table>
                <tr>
                    <td width="5%" height="100px">               
                    </td>
                    <td width="95%">
                       
                            <div style="font-family:Verdana;font-weight:bold; font-size:x-large; color:activecaption; " align="center" >
                                <i>LIBRARY</i>
                                <img src="../images/bookstack.jpg" alt="library" width="25%" height="25%" >
                            </div>
                      
                        <br/>
                            </td>
                </tr>                      
                        
                
            </table>
            <hr />
<a href="home.jsp" style="text-decoration: none;color: black;">&nbsp;&nbsp;
&nbsp;&nbsp;Home</a>
<div id="myslidemenu" align="left">
<form action="../LibServlet" method="get" >
<input type="text" name="form" value="form10" style="visibility: hidden" />

<table border="0" cellpadding="4" align="center">
	<tr>
		<td colspan="3">
		<h2 align="center">&nbsp;&nbsp; &nbsp;&nbsp; Borrower-Book Details</h2>

		</td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td colspan="3">
		</td>
	</tr>
		<tr>
		<td>Card No.:</td>
		<td><input type="text" title="Enter Card Number" id="cn"
			name="card_no" size="4" maxlength="4" /></td>
		<td></td>
	</tr>
	<tr>
		<td> Borrower Name:</td>
		<td><input type="text" title="Enter Borrower Name" id="bn"
			name="borrower_name" size="15" maxlength="15" /></td>
		<td></td>
	</tr>
			<td align="right"><input type="submit" value="Submit"
			onclick="return validate()" /></td>
		<td><input type="reset" value="Reset" /> &nbsp;&nbsp;<input
			type="button" value="Cancel"
			onclick="window.location.href='home.jsp'" /></td>
	</tr>
</table>
</form>
</div>


</body>

</html>