<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>kachok_FM.com</title>
    </head>
<%--JSTL DO NOT USE!!!!!--%>
    <body>
    <h1>Radio ${key}</h1>
        <form action="MyServlet.java" method="get">
            <input class="button" type="submit" value="Play"/>
            <input class="button" type="submit" value="Stop"/>
        </form>
    </body>
</html>