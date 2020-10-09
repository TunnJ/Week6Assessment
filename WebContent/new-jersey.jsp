<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a new jersey</title>
</head>
<body>

<form action="createNewJerseyServlet" method="post">

Jersey Color: <input type="text" name="jerseyColor"> <br>
Jersey Type: <input type="text" name="jerseyType"> <br>

Available Players:<br>

<select name="playerToAdd">
<c:forEach items="${requestScope.allPlayers}" var="currentplayers">
<option value="${currentplayers.id }">${currentplayers.name }</option>
</c:forEach>
</select>
<br>
<input type="submit" value="Create a jersey and add it to a player">
</form>
<a href="index.html">Add a new player instead</a>
</body>
</html>