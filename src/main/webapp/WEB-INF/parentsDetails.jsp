<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Parent</title>
</head>
<body>
<html:form action="save" method="post">
    <table >    
       <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
       </tr>    
       <tr>    
          <td>Salary :</td>    
          <td><form:input path="salary" /></td>  
       </tr>   
       <tr>    
          <td>Designation :</td>    
          <td><form:input path="designation" /></td>  
       </tr>   
       <tr>    
          <td colspan="2"><input type="submit" value="Save" /></td>    
       </tr>    
	</table>    
</html:form>    
</body>
</html>