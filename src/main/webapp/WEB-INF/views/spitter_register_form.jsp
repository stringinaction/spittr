<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Spitter Register!</h1>
        <a href="/homepage"><-gohome</a>
        <hr>
            
        <c:forEach items="${errors}" var="error" >
        <font color="red"><b>
                <li>
                    ${error.defaultMessage}
                </li>        
        </b></font>
        </c:forEach>
        
        <form method="POST">
            firstName: <input type="text" name="firstName" /><br><br>
            lastName: <input type="text" name="lastName" /><br><br>
            username: <input type="text" name="username" /><br><br>
            password: <input type="text" name="password" /><br><br>
            
            <input type="submit" value="submit" />
        </form>
    </body>
</html>
