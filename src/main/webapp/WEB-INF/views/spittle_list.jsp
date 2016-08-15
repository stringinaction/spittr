<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to Spittr List</h1>
        <a href="./homepage"><-gohome</a>
        <hr>
        <pre>
    //视图名为: spittles
    //参数名为: spittleList
    @RequestMapping(value="/spittle_list", method=GET)
    public List<Spittle> spittles(){
        return this.spittleRepository.findSpittles(Long.MAX_VALUE, 20); //向模型中加入数据
    }
        </pre>
        <hr>
        <c:forEach items="${spittleList}" var="spittle" >
        <li>
            ${spittle.message} | ${spittle.time}
        </li>
        </c:forEach>
    </body>
</html>