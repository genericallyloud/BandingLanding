<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Your deck, sir:
<ul>
	<c:forEach var="deckCard" items="${deckCards}">
		<li><c:out value="${deckCard.cardName}" /></li>
     </c:forEach>
</ul>
</body>
</html>