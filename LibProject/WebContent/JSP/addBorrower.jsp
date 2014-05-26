<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="author" content="Bhudev Sahu"/>
<meta name="description" content="Library Management System"/>
<title>Add Borrower</title>

<script type="text/javascript" src="../JS/borrowerValidation.js"></script>


</head>
<body background="../images/back-ground.jpg" >
<table>
                <tr>
                    <td width="5%" height="100px">               
                    </td>
                    <td width="95%">
                       
                            <div style="font-family:Verdana;font-weight:bold; 

font-size:x-large; color:activecaption; " align="center" >
                                <i>LIBRARY</i>
                                <img src="../images/bookstack.jpg" alt="library" 

width="25%" height="25%" >
                            </div>
                      
                        <br/>
                            </td>
                </tr>                      
                        
                
            </table>
            <hr />
<a href="home.jsp" style="text-decoration: none;color: black;">&nbsp;&nbsp;
&nbsp;&nbsp;Home</a>
<form action="../LibServlet" method="get" >
<input type="text" name="form" value="form5" style="visibility: hidden" />

<table border="0" cellpadding="4" align="center">
	<tr>
		<td colspan="3">
		<h2 align="center">&nbsp;&nbsp; &nbsp;&nbsp; Add New 

Borrower</h2>

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
		<td>First Name:<span class="mandat"><font size="3" color="red">
		*</font></span></td>

		<td><input type="text" title="Enter First Name" id="fn" 

name="fname"
			size="12" maxlength="12" /></td>
	</tr>
		<tr>
		<td>Last Name:<span class="mandat"><font size="3"
			color="red">*</font></span></td>
		<td><input type="text" title="Enter Last Name" id="ln"
			name="lname" size="12" maxlength="12" /></td>
		<td></td>
	</tr>
	<tr>
		<td>Address:<span class="mandat"><font size="3"
			color="red">*</font></span></td>
		<td colspan="2"><textarea id="add" name="address" rows="3" 

cols="25"
			title="Enter Address">
		</textarea></td>
	</tr>
	<tr>
		<td> Phone:<font size="3"></font></span></td>
		<td><input type="text" title="Enter Phone Number" id="pn"
			name="phone" size="15" maxlength="15" /></td>
		<td></td>
	</tr>
	<tr>
		<td>Card Number:<span class="mandat"><font size="3"
			color="red">*</font></span></td>
		<td><input type="text" title="Enter Card Number" id="cn"
			name="card" size="4" maxlength="4" /></td>
		<td></td>
	</tr>
			<td align="right"><input type="submit" value="Submit"
			onclick="return validate()" /></td>
		<td><input type="reset" value="Reset" /> &nbsp;&nbsp;<input
			type="button" value="cancel"
			onclick="window.location.href='home.jsp'" /></td>
	</tr>
</table>
</form>
</div>


</body>

</html>