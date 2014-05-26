<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Model.LibModel"%>
<html>
<head>
<meta name="author" content="Bhudev Sahu"/>
<meta name="description" content="Library Management System"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message</title>
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
<% String st = (String)request.getAttribute("st");%>
<h3 style="color: black; font-size: 28px"><%out.println(st); %></h3>

</div>
<br/><br/><br/><br/><br/><br/>
</body>
</html>