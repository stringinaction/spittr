<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to Spittr</h1>
        <a href="./homepage"><-gohome</a>
        <hr>
        <pre>
    @RequestMapping(value="/spittles", method=GET)
    public String spittles(Model model){
        //model中实际为KEY-Value的Map，当不指定KEY时，会默认根据类型指定，比如List<Spittle> : spittleList
        model.addAttribute("spittleList11", this.spittleRepository.findSpittles(Long.MAX_VALUE, 20)); //向模型中加入数据
        return "spittles";
    }
        </pre>
        <hr>
        <c:forEach items="${spittleList11}" var="spittle" >
        <li>
            ${spittle.message} | ${spittle.time}
        </li>
        </c:forEach>
    </body>
</html>
