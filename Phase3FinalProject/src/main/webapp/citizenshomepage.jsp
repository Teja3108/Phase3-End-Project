<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import = "com.example.demo.controller.*" %>
     <%@ page import = "com.example.demo.service.*" %>
      <%@ page import = "com.example.demo.pojo.*" %>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href = "#">Citizens</a>

<a href = "/home">Vaccination Centers</a>

<a href = "login.jsp">LogOut</a>
<a href = "#">Welcome, admin</a>

<h1>Citizens</h1>

<form action = "addcitizen.jsp">

<a href = "addcitizen.jsp">Add New Citizen</a>

</form>


<br><table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>City</th>
        <th>No. Of Doses</th>
        <th>Vaccination Status</th>
        <th>Vaccination Center</th>
        <th>Action</th>
    </tr>
    <% List<Citizens> citizenList = (List<Citizens>) request.getAttribute("citizenList"); %>
    <% if (citizenList != null) { %>
        <% for (Citizens citizen : citizenList) { %>
            <tr>
                <td><%= citizen.getId() %></td>
                <td><%= citizen.getName() %></td>
                <td><%= citizen.getCity() %></td>
                <td><%= citizen.getDoses() %></td>
                <td><%= citizen.getStatus() %></td>
            	<td><%= citizen.getCenter() %></td>
               
                <td><a href ="viewCitizens?id=<%= citizen.getId() %>">View</a>
                <a href ="citizenEdit.jsp?id=<%= citizen.getId() %>">Edit</a>
                <a href ="deleteCitizen/<%= citizen.getId() %>">Delete</a>

                </td>
            </tr>
        <% } %>
    <% } %>
    
</table>
<br>  <%="Total"+ " " + request.getAttribute("value")+ " "+"Vaccination Centers found" %>
</body>
</html>