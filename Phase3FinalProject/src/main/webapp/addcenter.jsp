<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style = "text-align: center">

<h1><i>Add New Vaccination Center</i></h1>

<form action = "centerinsert">

Center Name: <input type = "text" name = "name"><br><br>
Center City: 

<select name = "city">
<option>Hyderabad</option>
<option>Bangalore</option>
<option>Mumbai</option>
<option>New Delhi</option>
<option>Chennai</option>
<option>West Bengal</option>
<option>Pune</option>
</select><br><br>

<input type = "submit" value = "Add Center">
 
</form>

</div>
	



</body>
</html>