<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>${listEmploeeDetails}</th></tr>  
   <c:forEach var="emp" items="${listEmploeeDetails}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.salary}</td>  
   <td>${emp.designation}</td>  
   <td><a href="editemp/${emp.id}">Edit</a></td>  
   <td><a href="deleteemp/${emp.id}">Delete</a></td>
   </tr>  
   </c:forEach> 
   <%-- <tr th:each="emp : ${listEmploeeDetails}">
  			 <td><c:out value="${emp.id}"/></td>
  			 <td><c:out value="${emp.name}"/></td>
  			 <td><c:out value="${emp.salary}"/></td>
  			 <td><c:out value="${emp.designation}"/></td>
                <td>
                    <a th:href="/@{'/edit/' + ${emp.id}}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a th:href="/@{'/delete/' + ${emp.id}}">Delete</a>
                </td>
            </tr>  --%>
   </table>
</body>
</html>