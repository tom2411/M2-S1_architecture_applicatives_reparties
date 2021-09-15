
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
            <%-- ici ${meteo} est la valeur dans la requete : celle passee a l'invocation précédente... --%>
            <option value="${opt.key}" <c:if test="${opt.key==param.meteo}">selected</c:if>>
                    <%-- la session est une map : on chercher dedans une entrée avec le nom de l'option... --%>
                    ${opt.value} ${sessionScope[opt.value]}
            </option>
        </c:forEach>
    </select>
    <button type="submit">Valider</button>
</form>

</body>
</html>
