
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Pendu</title>
</head>
<body>
<p>bienvenu dans le jeu de pendu...</p>
Quel mot proposez-vous (en minuscules) ?
<form method="post">
    <input type="text" pattern="[a-z]*" minlength="1" name="lemot" required>
    <button type="submit" name="TODO" value="setMot">Envoyer</button>
</form>
</body>
</html>
