<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1><i>Center Information</i></h1>
<form action="updateCenter" method = "get">
    <h2>Edit KIMS Hospital</h2>
    <input type = "hidden" name=  "id" value = "<%= request.getParameter("id")%>">
    Center Name: <input type="text" name="name"><br><br>
    Center City: 
    <select name="city">
         <option>Hyderabad</option>
         <option>Mumbai</option>
         <option>Bangalore</option>
         <option>Chennai</option>
         <option>New Delhi</option>
         <option>West Bengal</option>
	    </select><br><br>
    <input type="submit" value="Submit">
</form>


</body>
</html>