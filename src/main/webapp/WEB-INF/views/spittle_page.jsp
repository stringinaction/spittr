<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to Spittr Page</h1>
        <a href="./homepage"><-gohome</a>
        <hr>
        <pre>
    @RequestMapping(value="/spittle_page", method=GET)
    public List<Spittle> spittles(@RequestParam("max") long max,
            @RequestParam("count") int count){
        return this.spittleRepository.findSpittles(max, count); //向模型中加入数据
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