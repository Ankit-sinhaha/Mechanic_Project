<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Driver</title>
</head>
<body>

<form:form action="update" modelAttribute="driver">

 <form:hidden path="id"/>
 
  FirstName : <form:input   path="firstName"/><br><br>

LastName  : <form:input  path="lastName"/><br><br>

EmailID : <form:input path="emailID"/><br><br>

Age : <form:input type="number"  path="age"/><br><br>

Contact Number : <form:input type="text" path="contact"/><br><br>

License Number : <form:input path="licenseNumber"/><br><br>

<input type="submit" value="Edit Driver">





</form:form>


<a href="viewAll">ViewAllEmployees </a>

</body>
</html>