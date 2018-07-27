<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Show Applications</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
   All Apps from DataBase
	<h3 style="color: red;">Show All Apps</h3>
	<ul>
		<c:forEach var="listValue" items="${apps}">
			<li>${listValue}</li>
		</c:forEach>
	</ul>
</body>
</html>