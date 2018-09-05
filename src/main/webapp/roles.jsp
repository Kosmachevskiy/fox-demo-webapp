<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Home page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:set var="prefix" value="${pageContext.request.contextPath}"/>
</head>
<body>
<a href="${prefix}/">Back</a><br>
<c:forEach var="role" items="${requestScope.roles}">
    [ID=${role.id}] Название:${role.name}
    Полномочия: <c:forEach var="permission" items="${role.permissions}">${permission} </c:forEach> <br>
</c:forEach>
</body>
</html>