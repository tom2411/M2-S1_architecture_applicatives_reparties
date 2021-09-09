
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>METEO</title>
</head>
<body>

<!-- implanter ici le nombre de fois où chaque option de météo a été validée -->

<form method="post">
    <select name="meteo">
        <c:forEach items="${options}" var="opt">
        <option value="${opt.key}">${opt.value}</option>
        </c:forEach>
    </select>
    <button type="submit">Valider</button>
</form>

</body>
</html>
