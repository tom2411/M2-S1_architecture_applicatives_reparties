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

<span style="color: red"> ${message} </span>

<form method="post">
    login : <input type="text" name="login"/>
    <br>
    mot de passe : <input type="password" name="password"/>
    <br>
    <button type="submit">Se logguer</button>
</form>

</body>
</html>
