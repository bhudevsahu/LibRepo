<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Model.LibModel"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="author" content="Bhudev Sahu"/>
<meta name="description" content="Library Management System"/>
<title>Check Book Details</title>

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

<h3 style="color: black; font-size: 28px">Book Details</h3>
<table border="1">
<tr>
<th>Book ID</th>
<th>Book Title</th>
<th>Book Author</th>
</tr>

<%
LibModel lm=(LibModel)request.getAttribute("data");
int a;
for(a=0;a<lm.book_ids.size();a++) {
%>
<tr>
	<td><%= lm.book_ids.get(a)%></td>
   <td><%= lm.book_titles.get(a)%></td>
	<td><%= lm.names.get(a)%></td>
</tr>
<% }%>

</table>
    </div>

</body>
</html>