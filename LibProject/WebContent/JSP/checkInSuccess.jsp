<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Model.LibModel"%>
<html>
<head>
<meta name="author" content="Bhudev Sahu"/>
<meta name="description" content="Library Management System"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checking In</title>
<script type="text/javascript" src="./JS/checkinValidation2.js"></script>

</head>

<body background="images/back-ground.jpg" >

<table>
                <tr>
                    <td width="5%" height="100px">               
                    </td>
                    <td width="95%">
                       
                            <div style="font-family:Verdana;font-weight:bold; font-size:x-large; color:activecaption; " align="center" >
                                <i>LIBRARY</i>
                                <img src="images/bookstack.jpg" alt="library" width="25%" height="25%" >
                            </div>
                      
                        <br/>
                            </td>
                </tr>                      
                        
                
            </table>
            <hr />
<a href="JSP/home.jsp" style="text-decoration: none;color: black;">&nbsp;&nbsp;
&nbsp;&nbsp;Home</a>
<div align="center">

<h3 style="color: black; font-size: 28px">Select the appropriate one by index#</h3>
<table border="1">
<tr>
<th>Index#</th>
<th>Book ID</th>
<th>Branch ID</th>
<th>Card No.</th>
<th>Date Out</th>
<th>Due Date</th>
</tr>

<%
LibModel lm=(LibModel)request.getAttribute("data");
int a;
for(a=0;a<lm.branch_id.size();a++) {
%>
<tr>
	<td><%= a+1%></td>
	<td><%= lm.book_ids.get(a)%></td>
   <td><%= lm.branch_id.get(a)%></td>
   <td><%= lm.cards.get(a)%></td>
   <td><%= lm.date_out.get(a)%></td>
   <td><%= lm.due_date.get(a)%></td>

</tr>
<% }%>

</table>
    
</div>

<form action="LibServlet" method="get" >
<input type="text" name="form" value="form4" style="visibility: hidden" />


<table border="0" cellpadding="4" align="center">

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
		
<td> Enter Index Value:</td>
<td><input type="text" title="Enter Index#" id="ind" name="index"
			size="2" maxlength="2" /></td></tr><tr>    
			<td align="right"><input type="submit" value="Submit"
			onclick="return validate()" /></td>
		<td><input type="reset" value="Reset" /> &nbsp;&nbsp;<input
			type="button" value="cancel"
			onclick="window.location.href='JSP/home.jsp'" /></td>
</table>
</form>

	
			

<br/><br/><br/><br/><br/><br/>

</body>
</html>