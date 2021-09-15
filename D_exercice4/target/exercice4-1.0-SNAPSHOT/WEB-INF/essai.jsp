
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Essai</title>
</head>
<body>
<p>Il est temps de deviner...</p>
Quel caractère proposez-vous (1 seul, en minuscule) ?
<form method="post">
    <input type="text" pattern="[a-z]" required name="lecaractere">
    <button type="submit"  name="TODO" value="essai">Envoyer</button> <!-- TODO compléter le bouton -->
</form>

Pour l'instant vous avez trouvé : ${etatCourant}.
<br>
Il vous reste ${nbEssaisRestants} essais.

</body>
</html>
