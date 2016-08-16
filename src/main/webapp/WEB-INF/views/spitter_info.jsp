<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Spitter Profile!</h1>
        <a href="/homepage"><-gohome</a>
        <hr>
        firstName: ${spitter.firstName}<br>
        lastName: ${spitter.lastName}<br>
        username: ${spitter.username}<br>
        password: ${spitter.password}<br>
    </body>
</html>
