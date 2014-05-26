<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="author" content="Bhudev Sahu"/>
<meta name="description" content="Library Management System"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Others</title>
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
<table border="0" cellpadding="4" align="center">
	<tr>
		<td colspan="3">
		<h2 align="center"> Other Features</h2>

		</td>
	</tr>
	</table>
<form action="../LibServlet" method="get" >
<div style="text-align:center">  	

<input type="submit"  name="form" value="Check In History"/>
<p></p>
<input type="submit"  name="form" value="Check Out History"/>
<p></p>
<input type="button" value="Update Borrower" onclick="window.location.href='checkCard.jsp'" />
<p></p>
<input type="button" value="Check Book Details" onclick="window.location.href='books.jsp'" />
<p></p>
<input type="button" value="Check Borrower-Book Details" onclick="window.location.href='borrower.jsp'" />
</div>
</form>
</body>
</html>