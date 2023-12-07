<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.pojo.Centers" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

    <a href="/home1">Citizens</a>
    <a href="/home2">Vaccination Centers</a>
    <a href="login.jsp">LogOut</a>
    <a href="#">Welcome, admin</a>

    <h1>Center Information</h1>

    <table border="1">
        <% List<Centers> centersList = (List<Centers>) request.getAttribute("centersList");
           if (centersList != null) {
               for (Centers center : centersList) { %>
         
               <h2><%= center.getName() %></h2>
             
                   <tr>
                       <td>ID:</td>
                       <td><%= center.getId() %></td>
                   </tr>
                 
                       <td>City:</td>
                       <td><%= center.getCity() %></td>
                   </tr>
        <%     }
           } %>
    </table>
   
    
    <h2>All Citizens of this center</h2>
    
  <table border="1">
    
    		<tr>
    		<th>ID</th>
    		<th>Name</th>
    		<th>Action</th>
    		</tr>
    		<tr>
    		<td>3</td>
    		<td>Harin</td>
    		<td><a href = "viewCitizens?id=3">view</a></td>
    		</tr>
    		<tr>
    		<td>5</td>
    		<td>Charan</td>
    		<td><a href = "viewCitizens?id=5">view</a></td>
    		</tr>
    
    </table>
   
    
    
</body>
</html>
