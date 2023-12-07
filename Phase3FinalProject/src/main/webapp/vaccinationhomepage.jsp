<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.example.demo.pojo.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<a href = "/home1">Citizens</a>
<a href = "/home2">Vaccination Centers</a>
<a href = "login.jsp">LogOut</a>
<a href = "#">Welcome, admin</a>

 
<h2>Centers</h2>

<form action =  "addcenter.jsp">
<input type = "submit" value = "Add New Center">
</form>
<br>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>City</th>
        <th>Action</th>
    </tr>
    <% List<Centers> centersList = (List<Centers>) request.getAttribute("centersList"); %>
    <% if (centersList != null) { %>
        <% for (Centers center : centersList) { %>
            <tr>
                <td><%= center.getId() %></td>
                <td><%= center.getName() %></td>
                <td><%= center.getCity() %></td>
                <td><a href ="viewCenters?id=<%= center.getId() %>">View</a>
                <a href ="centerEdit.jsp?id=<%= center.getId() %>">Edit</a>
                <a href ="delete/<%= center.getId() %>">Delete</a>

                </td>
            </tr>
        <% } %>
    <% } %>
    
</table>
<br>  <%="Total"+ " " + request.getAttribute("val")+ " "+"Vaccination Centers found" %>


 
 


</body>
</html>

