<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>La valeur a été mémorisée</title>
</head>
<body>
    Elle est maintenant en session.
    Pour la retrouver,
<form method="get" action="SecondServlet">
    <button type="submit">cliquer ici</button>
</form>
</body>
</html>
