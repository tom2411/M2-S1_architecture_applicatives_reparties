<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TODO</title>
</head>
<body>
<H2>Invocation d'un servlet unique avec indication de l'action attendue (contrôleur)</H2>
<br/>
    <div class="block">
    A l'appel précédent, la valeur de TODO était : ${previoustodo}
    <br>
    Je répond donc : ${msg}
    </div>

    <br/>
    <div class="block">
        <h3>Tout d'abord via une url (hyperlien -> GET)</h3>
        <a href="TodoServlet?TODO=bonjour">bonjour</a>
        <br>
        <a href="TodoServlet?TODO=beau">il fait beau</a>
        <br>
        <a href="TodoServlet">sans passer de TODO</a>
    </div>

    <div>
        <h3>Puis avec un formulaire (POST)</h3>
        <form method="post"  action="TodoServlet">
            <button type="submit" name="TODO" value="bonjour">bonjour</button>
            <button type="submit" name="TODO" value="beau">il fait beau</button>
            <button type="submit" name="BIDON" value="bidon">Sans passer de TODO</button>
        </form>
    </div>
</body>
</html>
