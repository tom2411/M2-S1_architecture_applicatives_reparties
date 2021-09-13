
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Essai</title>
</head>
<body>
<c:if test="${empty coup}">
    <p>Il est temps de deviner...</p>
    <p>il vous reste ${coupRestant} coups.</p>
    Quel caractère proposez-vous ?
</c:if>
<c:if test="${not empty coup}">
    Bravo vous avez réussi à trouver le mot mystère.
    <br>
    Il vous restait ${coup} coups.
</c:if>
<form method="post">
    <input type="text" name="lecaractere" pattern="[A-Za-z]{0,27}">
    <c:if test="${empty fin}">
        <button type="submit">Envoyer</button> <!-- TODO compléter le bouton -->
    </c:if>
    <c:if test="${not empty fin}">
        <button type="submit" disabled>Envoyer</button> <!-- TODO compléter le bouton -->
    </c:if>
</form>
<c:if test="${not empty erreur}">
    <p style="color: red">${erreur}</p>
</c:if>

Pour l'instant vous avez trouvé : ${devine}<!-- TODO le mot en partie découvert (ou pas)-->


</body>
</html>
