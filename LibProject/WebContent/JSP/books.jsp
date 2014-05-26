<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="author" content="Bhudev Sahu"/>
<meta name="description" content="Library Management System"/>
<title>Check Book Details</title>

<script type="text/javascript" src="../JS/bookAvailValidation.js"></script>


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
<form action="../LibServlet" method="get" >
<input type="text" name="form" value="form9" style="visibility: hidden" />

<table border="0" cellpadding="4" align="center">
	<tr>
		<td colspan="3">
		<h2 align="center">&nbsp;&nbsp; &nbsp;&nbsp; Check Book Details</h2>

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
		<td>Book ID:</td>

		<td><input type="text" title="Enter Book ID" id="bi" name="book_id"
			size="12" maxlength="10" /></td>
	</tr>
		<tr>
		<td>Title:</span></td>
		<td><input type="text" title="Enter Book Title" id="titl"
			name="title" size="80" maxlength="77" /></td>
		<td></td>
	</tr>
	<tr>
		<td> Author Name:<font size="3"></font></span></td>
		<td><input type="text" title="Enter Author Name" id="an"
			name="author_name" size="35" maxlength="32" /></td>
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