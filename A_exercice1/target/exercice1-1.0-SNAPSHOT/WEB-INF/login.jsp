<%--
Cette JSP accueillera un form avec les deux champs login et password
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>LOGIN</title>
</head>
<body>
<c:if test="${empty who_is_there}">
    <form method="post">
        <label> Login
            <input type="text" name="login">
        <br>
        </label> Mot de passe
            <input type="password" name="mdp">
        <br/>
        <button type="submit">Envoyer</button>
        <c:if test="${not empty erreur}">
            <p style="color: red">${erreur}</p>
        </c:if>
    </form>
</c:if>
</body>
</html>
