<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to Spittr Page(max=${max} count=${count})</h1>
        <a href="./homepage"><-gohome</a>
        <hr>
        <pre>
    @RequestMapping(value="/spittle_page", method=GET)
    public String spittles(@RequestParam(value="max", defaultValue="1000") long max,
            @RequestParam(value="count", defaultValue="10") int count,
            Model model){
        model.addAttribute("spittleList", this.spittleRepository.findSpittles(max, count));
        model.addAttribute("max", max);
        model.addAttribute("count", count);
        return "spittle_page"; //向模型中加入数据
    }
        </pre>
        <hr>
        <c:forEach items="${spittleList}" var="spittle" >
        <li>
            ${spittle.message} | ${spittle.time}
        </li>
        </c:forEach>
    </body>
</html>`
