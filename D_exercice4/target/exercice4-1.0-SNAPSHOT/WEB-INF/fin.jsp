
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Fin de partie</title>
</head>
<body>
<c:choose >
    <c:when test="${victoire}">
        Bravo, vous avez gagné !
    </c:when>
    <c:otherwise>
        Vous avez perdu!
    </c:otherwise>
</c:choose>

<p>Le mot à trouver était ${mot}</p>


</body>
</html>
