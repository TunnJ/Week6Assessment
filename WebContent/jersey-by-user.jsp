<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Jerseys</title>
</head>
<body>

<form  method="post" action="navigationJerseyServlet">
	<table>
	<c:forEach items="${requestScope.allJerseys }" var="currentlist">
	<tr>
		<td><input type="radio" name="id" value="${currentlist.id }"></td>
		<td><h3>${currentlist.player.name }</h3></td></tr>
		<tr><td><h2>${currentlist.color }</h2></td></tr>
		<tr><td><h2>${currentlist.type }</h2></td></tr>
	</c:forEach>
	</table>
	<input type="submit" value="delete" name="doThisToJersey">
	<input type="submit" value="add" name="doThisToJersey">
</form>

<a href="new-jersey.jsp">Add a new jersey</a>
</body>
</html>