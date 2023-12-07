<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.pojo.Citizens" %>
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

    <h1>Citizen Information</h1>
  <table border="1">
    <% List<Citizens> citizenList = (List<Citizens>) request.getAttribute("citizenList");
       if (citizenList != null) {
           for (Citizens citizen : citizenList) { %>
                    <h2 style = "padding-left: 40px"><%= citizen.getName() %></h2>
                   <tr>
                       <td>ID:</td>
                       <td><%= citizen.getId() %></td>
                   </tr>
                   <tr>
                       <td>City:</td>
                       <td><%= citizen.getCity() %></td>
                   </tr>
                    <tr>
                       <td>Doses:</td>
                       <td><%= citizen.getDoses() %></td>
                   </tr>
                   <tr>
                       <td>Status:</td>
                       <td><%= citizen.getStatus() %></td>
                   </tr>
                   <tr>
                       <td>Center:</td>
                       <td><%= citizen.getCenter() %></a></td>
                   </tr>
               </div>
    <%     }
       } %>
       </table>
</body>
</html>
