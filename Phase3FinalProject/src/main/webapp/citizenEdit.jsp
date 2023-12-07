<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Citizen Information</h1>
<h2>Edit Citizen</h2>
<form action = "updateCitizen" method = "Get">
<input type = "hidden" name=  "id" value = "<%= request.getParameter("id")%>">
Citizen Name : <input type ="text" name = "name"><br><br>

Citizen City:

<select name = "city">
<option>Hyderabad</option>
<option>Bangalore</option>
<option>Mumbai</option>
<option>New Delhi</option>
<option>Chennai</option>
<option>West Bengal</option>
<option>Pune</option>
</select><br><br>

No. Of Doses: 

<select name = "doses">

<option>None</option>
<option>0</option>
<option>1</option>
<option>2</option>
</select><br><br>

Citizen Center: 

<select name = "center">
<option>City Hospital</option>
<option>Apollo Hospital</option>
<option>Care Hospital</option>
<option>Sunshine Hospital</option>
<option>Save Hospital</option>
<option>Good Well Hospital</option>
<option>KIMS Hospital</option>
</select><br><br>

<input type = "submit" value = "Submit">


</form>

</body>
</html>